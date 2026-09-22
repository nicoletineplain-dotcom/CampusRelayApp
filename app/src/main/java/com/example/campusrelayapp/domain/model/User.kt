package com.example.campusrelayapp.domain.model

data class User(

    val id: String,

    val name: String,

    val email: String,

    val studentNumber: String? = null,

    val ecoScore: Double = 0.0
)