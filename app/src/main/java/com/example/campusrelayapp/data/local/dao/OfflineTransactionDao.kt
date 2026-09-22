package com.example.campusrelayapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.campusrelayapp.data.local.entity.OfflineTransactionEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface OfflineTransactionDao {

    @Query(
        """
        SELECT *
        FROM offline_transactions
        WHERE synced = 0
        ORDER BY createdAt
        """
    )
    suspend fun getPendingTransactions():
            List<OfflineTransactionEntity>

    @Query(
        """
        SELECT COUNT(*)
        FROM offline_transactions
        WHERE synced = 0
        """
    )
    fun getPendingCount(): Flow<Int>

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertTransaction(
        transaction: OfflineTransactionEntity
    )

    @Query(
        """
        UPDATE offline_transactions
        SET synced = 1
        WHERE id = :id
        """
    )
    suspend fun markCompleted(
        id: String
    )

    @Query(
        """
        UPDATE offline_transactions
        SET attempts = attempts + 1
        WHERE id = :id
        """
    )
    suspend fun increaseAttempts(
        id: String
    )

    @Query(
        """
        DELETE FROM offline_transactions
        WHERE synced = 1
        """
    )
    suspend fun deleteCompletedTransactions()
}