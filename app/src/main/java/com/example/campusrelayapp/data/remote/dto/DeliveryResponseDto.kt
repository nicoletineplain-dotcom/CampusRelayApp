package com.example.campusrelayapp.data.remote.dto

data class DeliveryResponseDto(

    val id: String,

    val requesterId: String,

    val pickup: String,

    val dropoff: String,

    val status: String,

    val price: Double,

    val ecoKg: Double = 0.0
)