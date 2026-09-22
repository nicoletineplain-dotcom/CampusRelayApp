package com.example.campusrelayapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageEntity(

    @PrimaryKey
    val id: String,

    val transactionId: String,

    val senderId: String,

    val content: String,

    val sentAt: Long
)