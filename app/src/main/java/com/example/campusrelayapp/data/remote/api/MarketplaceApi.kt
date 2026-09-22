package com.example.campusrelayapp.data.remote.api

import com.example.campusrelayapp.data.remote.dto.MarketplaceDto
import retrofit2.Response
import retrofit2.http.GET

/**
 * Marketplace API.
 */
interface MarketplaceApi {

    /**
     * Get marketplace listings.
     */
    @GET("api/marketplace")
    suspend fun getMarketplaceItems():
            Response<List<MarketplaceDto>>
}