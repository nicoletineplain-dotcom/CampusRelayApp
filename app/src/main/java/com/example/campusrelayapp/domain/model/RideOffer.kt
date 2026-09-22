package com.example.campusrelayapp.domain.model
data class RideOffer(

    val id: String,

    val driverId: String,

    val origin: String,

    val destination: String,

    val seats: Int,

    val pricePerSeat: Double,

    val status: String
)

