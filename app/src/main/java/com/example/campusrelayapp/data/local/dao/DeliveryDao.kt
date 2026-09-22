package com.example.campusrelayapp.data.local.dao

import androidx.room.*

import com.example.campusrelayapp.data.local.entity.DeliveryEntity

@Dao
interface DeliveryDao {

    @Query(
        "SELECT * FROM deliveries ORDER BY rowid DESC"
    )
    suspend fun getAll():
            List<DeliveryEntity>

    @Query(
        "SELECT * FROM deliveries WHERE synced = 0"
    )
    suspend fun getPendingSync():
            List<DeliveryEntity>

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun upsert(
        delivery: DeliveryEntity
    )

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun upsertAll(
        deliveries: List<DeliveryEntity>
    )

    @Query(
        "UPDATE deliveries SET synced = 1 WHERE id = :id"
    )
    suspend fun markAsSynced(
        id: String
    )

    @Query(
        """
        UPDATE deliveries
        SET status = 'COMPLETED',
            synced = 0
        WHERE id = :id
        """
    )
    suspend fun markCompleted(
        id: String
    )
}