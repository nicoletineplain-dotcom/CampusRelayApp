package com.example.campusrelayapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marketplace")
data class MarketplaceEntity(

    @PrimaryKey
    val id: String,

    val sellerId: String,

    val title: String,

    val category: String,

    val price: Double,

    val condition: String,

    val status: String = "ACTIVE"
)