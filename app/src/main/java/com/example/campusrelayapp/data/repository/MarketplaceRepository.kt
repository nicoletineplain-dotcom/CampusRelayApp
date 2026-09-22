package com.example.campusrelayapp.data.repository

import com.example.campusrelayapp.data.local.dao.MarketplaceDao
import com.example.campusrelayapp.data.local.entity.MarketplaceEntity
import com.example.campusrelayapp.data.remote.api.ApiService
import com.example.campusrelayapp.data.remote.dto.MarketplaceDto

class MarketplaceRepository(

    private val api: ApiService,

    private val dao: MarketplaceDao

) {

    suspend fun feed():
            List<MarketplaceDto> {

        return try {

            val remote =
                api.marketplace()

            dao.upsertAll(

                remote.map {

                    MarketplaceEntity(

                        id =
                            it.id,

                        sellerId =
                            it.sellerId,

                        title =
                            it.title,

                        category =
                            it.category,

                        price =
                            it.price,

                        condition =
                            it.condition,

                        status =
                            it.status
                    )
                }
            )

            remote

        } catch (exception: Exception) {

            dao.getAll()
                .map {

                    MarketplaceDto(

                        id =
                            it.id,

                        sellerId =
                            it.sellerId,

                        title =
                            it.title,

                        category =
                            it.category,

                        price =
                            it.price,

                        condition =
                            it.condition,

                        status =
                            it.status
                    )
                }
        }
    }
}