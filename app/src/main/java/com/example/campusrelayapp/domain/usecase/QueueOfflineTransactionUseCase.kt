package com.example.campusrelayapp.domain.usecase

import com.example.campusrelayapp.data.repository.OfflineSyncRepository

/**
 * Adds an operation to the offline queue.
 */
class QueueOfflineTransactionUseCase(
    private val offlineSyncRepository:
    OfflineSyncRepository
) {

    /**
     * Store an operation locally so that it can
     * be synchronized later.
     */
    suspend operator fun invoke(
        operationType: String,
        objectId: String,
        payload: String,
        createdAt: String
    ) {

        offlineSyncRepository.queueTransaction(

            operationType =
                operationType,

            objectId =
                objectId,

            payload =
                payload,

            createdAt =
                createdAt
        )
    }
}