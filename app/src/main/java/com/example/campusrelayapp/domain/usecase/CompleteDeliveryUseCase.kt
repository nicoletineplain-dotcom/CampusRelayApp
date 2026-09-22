package com.example.campusrelayapp.domain.usecase

import com.example.campusrelayapp.data.repository.DeliveryRepository

/**
 * Use case for completing a delivery.
 */
class CompleteDeliveryUseCase(
    private val deliveryRepository: DeliveryRepository
) {

    /**
     * Marks the delivery as completed.
     */
    suspend operator fun invoke(
        deliveryId: String
    ): Result<Unit> {

        return deliveryRepository.complete(
            deliveryId
        )
    }
}