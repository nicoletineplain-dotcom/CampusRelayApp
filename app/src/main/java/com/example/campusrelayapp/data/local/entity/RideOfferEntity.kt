package com.example.campusrelayapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ride_offers")
data class RideOfferEntity(

    @PrimaryKey
    val id: String,

    val driverId: String,

    val origin: String,

    val destination: String,

    val seats: Int,

    val pricePerSeat: Double,

    val status: String = "ACTIVE"
)