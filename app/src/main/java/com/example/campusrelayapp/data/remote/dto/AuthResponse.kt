package com.example.campusrelayapp.data.remote.dto

data class AuthResponse(

    val userId: String,

    val email: String,

    val name: String,

    val accessToken: String?
)