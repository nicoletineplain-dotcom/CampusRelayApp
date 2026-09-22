package com.example.campusrelayapp.domain.usecase

import com.example.campusrelayapp.data.repository.OfflineSyncRepository

/**
 * Handles synchronization of pending offline transactions.
 */
class SyncOfflineUseCase(
    private val offlineSyncRepository: OfflineSyncRepository
) {

    /**
     * Executes offline synchronization.
     *
     * Pending transactions are processed one at a time.
     */
    suspend operator fun invoke(): Result<Unit> {

        return try {

            val transactions =
                offlineSyncRepository.getPendingTransactions()

            for (transaction in transactions) {

                try {

                    /*
                     * The actual server operation should be
                     * performed here based on transaction.type.
                     *
                     * For now, the transaction is marked as
                     * completed after it has been processed.
                     */
                    offlineSyncRepository.markCompleted(
                        transaction.id
                    )

                } catch (exception: Exception) {

                    offlineSyncRepository.increaseAttempts(
                        transaction.id
                    )
                }
            }

            offlineSyncRepository.cleanCompletedTransactions()

            Result.success(Unit)

        } catch (exception: Exception) {

            Result.failure(exception)
        }
    }
}