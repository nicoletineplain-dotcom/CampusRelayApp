package com.example.campusrelayapp.domain.model
data class Message(

    val id: String,

    val transactionId: String,

    val senderId: String,

    val content: String,

    val sentAt: Long
)
