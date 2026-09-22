package com.example.campusrelayapp.data.repository

import com.example.campusrelayapp.data.local.dao.DeliveryDao
import com.example.campusrelayapp.data.local.entity.DeliveryEntity
import com.example.campusrelayapp.data.remote.api.ApiService
import com.example.campusrelayapp.data.remote.dto.DeliveryRequestDto
import com.example.campusrelayapp.domain.model.Delivery

class DeliveryRepository(

    private val api: ApiService,

    private val dao: DeliveryDao

) {

    suspend fun feed():
            List<Delivery> {

        return try {

            val remote =
                api.getDeliveryFeed()

            val entities =
                remote.map {

                    DeliveryEntity(

                        id = it.id,

                        requesterId =
                            it.requesterId,

                        pickup =
                            it.pickup,

                        dropoff =
                            it.dropoff,

                        status =
                            it.status,

                        price =
                            it.price,

                        ecoKg =
                            it.ecoKg,

                        synced = true
                    )
                }

            dao.upsertAll(
                entities
            )

            entities.map {
                it.toDomain()
            }

        } catch (exception: Exception) {

            /*
             * Offline fallback.
             *
             * This is one of the important CampusRelay
             * reliability features.
             */
            dao.getAll()
                .map {
                    it.toDomain()
                }
        }
    }

    suspend fun create(
        delivery: Delivery
    ): Result<Delivery> {

        return try {

            val response =
                api.createDelivery(

                    DeliveryRequestDto(

                        id =
                            delivery.id,

                        requesterId =
                            delivery.requesterId,

                        pickup =
                            delivery.pickup,

                        dropoff =
                            delivery.dropoff,

                        price =
                            delivery.price
                    )
                )

            val entity =
                DeliveryEntity(

                    id =
                        response.id,

                    requesterId =
                        response.requesterId,

                    pickup =
                        response.pickup,

                    dropoff =
                        response.dropoff,

                    status =
                        response.status,

                    price =
                        response.price,

                    ecoKg =
                        response.ecoKg,

                    synced = true
                )

            dao.upsert(entity)

            Result.success(
                entity.toDomain()
            )

        } catch (exception: Exception) {

            /*
             * Network unavailable.
             *
             * Store locally and allow WorkManager to
             * upload the transaction later.
             */
            dao.upsert(

                DeliveryEntity(

                    id =
                        delivery.id,

                    requesterId =
                        delivery.requesterId,

                    pickup =
                        delivery.pickup,

                    dropoff =
                        delivery.dropoff,

                    status =
                        "PENDING",

                    price =
                        delivery.price,

                    ecoKg =
                        delivery.ecoKg,

                    synced = false
                )
            )

            Result.success(
                delivery.copy(
                    status = "PENDING"
                )
            )
        }
    }

    suspend fun complete(
        id: String
    ): Result<Unit> {

        return try {

            dao.markCompleted(id)

            Result.success(Unit)

        } catch (exception: Exception) {

            Result.failure(exception)
        }
    }

    suspend fun syncOffline():
            Result<Unit> {

        return try {

            val pending =
                dao.getPendingSync()

            if (pending.isNotEmpty()) {

                val responses =
                    api.syncDeliveries(

                        pending.map {

                            DeliveryRequestDto(

                                id = it.id,

                                requesterId =
                                    it.requesterId,

                                pickup =
                                    it.pickup,

                                dropoff =
                                    it.dropoff,

                                price =
                                    it.price
                            )
                        }
                    )

                responses.forEach {

                    dao.markAsSynced(
                        it.id
                    )
                }
            }

            Result.success(Unit)

        } catch (exception: Exception) {

            Result.failure(exception)
        }
    }

    private fun DeliveryEntity.toDomain():
            Delivery {

        return Delivery(

            id = id,

            requesterId =
                requesterId,

            pickup =
                pickup,

            dropoff =
                dropoff,

            status =
                status,

            price =
                price,

            ecoKg =
                ecoKg
        )
    }
}