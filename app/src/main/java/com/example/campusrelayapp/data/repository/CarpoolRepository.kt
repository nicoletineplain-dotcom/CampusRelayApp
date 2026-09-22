package com.example.campusrelayapp.data.repository

import com.example.campusrelayapp.data.local.dao.RideOfferDao
import com.example.campusrelayapp.data.local.entity.RideOfferEntity
import com.example.campusrelayapp.data.remote.api.ApiService
import com.example.campusrelayapp.data.remote.dto.RideOfferDto

class CarpoolRepository(
    private val api: ApiService,
    private val dao: RideOfferDao
) {

    suspend fun feed(): List<RideOfferDto> {

        return try {

            val remote = api.rides()

            dao.upsertAll(
                remote.map {
                    RideOfferEntity(
                        id = it.id,
                        driverId = it.driverId,
                        origin = it.origin,
                        destination = it.destination,
                        seats = it.seats,
                        pricePerSeat = it.pricePerSeat,
                        status = it.status
                    )
                }
            )

            remote

        } catch (exception: Exception) {

            dao.getAll().map {
                RideOfferDto(
                    id = it.id,
                    driverId = it.driverId,
                    origin = it.origin,
                    destination = it.destination,
                    seats = it.seats,
                    pricePerSeat = it.pricePerSeat,
                    status = it.status
                )
            }
        }
    }

    suspend fun createRide(
        ride: RideOfferDto
    ): Result<RideOfferEntity> {

        return try {

            val response = api.createRide(ride)

            val entity = RideOfferEntity(
                id = response.id,
                driverId = response.driverId,
                origin = response.origin,
                destination = response.destination,
                seats = response.seats,
                pricePerSeat = response.pricePerSeat,
                status = response.status
            )

            dao.upsert(entity)

            Result.success(entity)

        } catch (exception: Exception) {

            val entity = RideOfferEntity(
                id = ride.id.ifBlank {
                    java.util.UUID.randomUUID().toString()
                },
                driverId = ride.driverId,
                origin = ride.origin,
                destination = ride.destination,
                seats = ride.seats,
                pricePerSeat = ride.pricePerSeat,
                status = "PENDING"
            )

            dao.upsert(entity)

            Result.success(entity)
        }
    }
}