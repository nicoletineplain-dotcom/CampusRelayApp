package com.example.campusrelayapp.data.remote.api

import com.example.campusrelayapp.data.remote.dto.DeliveryRequestDto
import com.example.campusrelayapp.data.remote.dto.DeliveryResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Delivery API endpoints.
 */
interface DeliveryApi {

    /**
     * Get all deliveries.
     */
    @GET("api/deliveries")
    suspend fun getDeliveries():
            Response<List<DeliveryResponseDto>>

    /**
     * Create a new delivery.
     */
    @POST("api/deliveries")
    suspend fun createDelivery(
        @Body request: DeliveryRequestDto
    ): Response<DeliveryResponseDto>
}