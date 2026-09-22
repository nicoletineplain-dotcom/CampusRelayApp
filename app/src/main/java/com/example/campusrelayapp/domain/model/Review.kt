package com.example.campusrelayapp.domain.model


data class Review(

    val id: String,

    val transactionId: String,

    val reviewerId: String,

    val revieweeId: String,

    val rating: Int,

    val comment: String?,

    val createdAt: Long
)