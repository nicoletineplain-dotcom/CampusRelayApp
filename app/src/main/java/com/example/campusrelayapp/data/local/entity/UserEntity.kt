package com.example.campusrelayapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey
    val id: String,

    val name: String,

    val email: String,

    val studentNumber: String? = null,

    val ecoScore: Double = 0.0
)