package com.example.campusrelayapp.data.remote.api

import com.example.campusrelayapp.data.remote.dto.RideOfferDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

/**
 * Carpool API.
 */
interface CarpoolApi {

    /**
     * Get available ride offers.
     */
    @GET("api/carpool")
    suspend fun getRideOffers():
            Response<List<RideOfferDto>>

    /**
     * Create a ride offer.
     */
    @POST("api/carpool")
    suspend fun createRideOffer(
        @Body ride: RideOfferDto
    ): Response<RideOfferDto>
}