package com.example.campusrelayapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "offline_transactions")
data class OfflineTransactionEntity(

    @PrimaryKey
    val id: String,

    val type: String,

    val payload: String,

    val createdAt: Long,

    val synced: Boolean = false,

    val attempts: Int = 0
)