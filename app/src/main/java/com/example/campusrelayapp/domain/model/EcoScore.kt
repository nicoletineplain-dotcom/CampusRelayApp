package com.example.campusrelayapp.domain.model

data class EcoScore(

    val userId: String,

    val co2SavedKg: Double,

    val rank: Int,

    val badge: String
)
