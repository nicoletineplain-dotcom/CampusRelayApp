package com.example.campusrelayapp.data.remote.api

import com.example.campusrelayapp.data.remote.dto.*

import retrofit2.http.*

interface ApiService {

    // -------------------------------
    // Authentication
    // -------------------------------

    @POST("api/v1/auth/sso")
    suspend fun authenticate(
        @Body request: AuthRequest
    ): AuthResponse


    // -------------------------------
    // Deliveries
    // -------------------------------

    @POST("api/v1/deliveries")
    suspend fun createDelivery(
        @Body request: DeliveryRequestDto
    ): DeliveryResponseDto

    @GET("api/v1/deliveries/feed")
    suspend fun getDeliveryFeed():
            List<DeliveryResponseDto>

    @POST("api/v1/deliveries/sync-offline")
    suspend fun syncDeliveries(
        @Body deliveries:
        List<DeliveryRequestDto>
    ): List<DeliveryResponseDto>


    // -------------------------------
    // Marketplace
    // -------------------------------

    @GET("api/v1/marketplace")
    suspend fun marketplace():
            List<MarketplaceDto>

    @POST("api/v1/marketplace")
    suspend fun createListing(
        @Body listing: MarketplaceDto
    ): MarketplaceDto


    // -------------------------------
    // Carpool
    // -------------------------------

    @GET("api/v1/carpool/rides")
    suspend fun rides():
            List<RideOfferDto>

    @POST("api/v1/carpool/rides")
    suspend fun createRide(
        @Body ride: RideOfferDto
    ): RideOfferDto
}