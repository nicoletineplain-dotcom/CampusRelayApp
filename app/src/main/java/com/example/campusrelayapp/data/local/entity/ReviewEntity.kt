package com.example.campusrelayapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reviews")
data class ReviewEntity(

    @PrimaryKey
    val id: String,

    val transactionId: String,

    val reviewerId: String,

    val revieweeId: String,

    val rating: Int,

    val comment: String?,

    val createdAt: Long
)