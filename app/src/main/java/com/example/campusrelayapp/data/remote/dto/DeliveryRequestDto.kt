package com.example.campusrelayapp.data.remote.dto

data class DeliveryRequestDto(

    val id: String,

    val requesterId: String,

    val pickup: String,

    val dropoff: String,

    val price: Double
)