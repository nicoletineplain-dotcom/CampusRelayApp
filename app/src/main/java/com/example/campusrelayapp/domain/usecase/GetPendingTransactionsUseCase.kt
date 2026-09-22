package com.example.campusrelayapp.domain.usecase

import com.example.campusrelayapp.data.repository.OfflineSyncRepository
import com.example.campusrelayapp.domain.model.OfflineTransaction

/**
 * Gets operations that are waiting for synchronization.
 */
class GetPendingTransactionsUseCase(
    private val offlineSyncRepository: OfflineSyncRepository
) {

    /**
     * Execute the use case.
     */
    suspend operator fun invoke(): List<OfflineTransaction> {

        val transactions =
            offlineSyncRepository.getPendingTransactions()

        return transactions.map { entity ->

            OfflineTransaction(
                id = entity.id,
                type = entity.type,
                payload = entity.payload,
                createdAt = entity.createdAt,
                synced = entity.synced,
                attempts = entity.attempts
            )
        }
    }
}