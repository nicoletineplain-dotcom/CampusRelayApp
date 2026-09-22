package com.example.campusrelayapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliveries")
data class DeliveryEntity(

    @PrimaryKey
    val id: String,

    val requesterId: String,

    val pickup: String,

    val dropoff: String,

    val status: String,

    val price: Double,

    val ecoKg: Double,

    val synced: Boolean = false
)