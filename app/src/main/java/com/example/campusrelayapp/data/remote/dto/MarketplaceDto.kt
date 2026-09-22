package com.example.campusrelayapp.data.remote.dto

data class MarketplaceDto(

    val id: String,

    val sellerId: String,

    val title: String,

    val category: String,

    val price: Double,

    val condition: String,

    val status: String = "ACTIVE"
)