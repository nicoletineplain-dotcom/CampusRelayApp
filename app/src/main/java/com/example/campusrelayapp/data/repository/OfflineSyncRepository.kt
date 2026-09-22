package com.example.campusrelayapp.data.repository

import com.example.campusrelayapp.data.local.dao.OfflineTransactionDao
import com.example.campusrelayapp.data.local.entity.OfflineTransactionEntity

import kotlinx.coroutines.flow.Flow

class OfflineSyncRepository(
    private val transactionDao: OfflineTransactionDao
) {

    fun getPendingCount(): Flow<Int> {

        return transactionDao.getPendingCount()
    }

    suspend fun queueTransaction(
        operationType: String,
        objectId: String,
        payload: String,
        createdAt: String
    ) {

        val transaction =
            OfflineTransactionEntity(

                id = objectId,

                type = operationType,

                payload = payload,

                createdAt =
                    createdAt.toLongOrNull()
                        ?: System.currentTimeMillis()
            )

        transactionDao.insertTransaction(
            transaction
        )
    }

    suspend fun getPendingTransactions():
            List<OfflineTransactionEntity> {

        return transactionDao.getPendingTransactions()
    }

    suspend fun markCompleted(
        transactionId: String
    ) {

        transactionDao.markCompleted(
            transactionId
        )
    }

    suspend fun increaseAttempts(
        transactionId: String
    ) {

        transactionDao.increaseAttempts(
            transactionId
        )
    }

    suspend fun cleanCompletedTransactions() {

        transactionDao.deleteCompletedTransactions()
    }
}