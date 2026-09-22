package com.example.campusrelayapp.data.remote.dto

data class RideOfferDto(

    val id: String,

    val driverId: String,

    val origin: String,

    val destination: String,

    val seats: Int,

    val pricePerSeat: Double,

    val status: String = "ACTIVE"
)