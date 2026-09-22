package com.example.campusrelayapp.domain.usecase

import com.example.campusrelayapp.data.repository.DeliveryRepository
import com.example.campusrelayapp.domain.model.Delivery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Gets delivery information for the application.
 */
class GetDeliveriesUseCase(
    private val deliveryRepository: DeliveryRepository
) {

    /**
     * Returns deliveries as a Flow.
     */
    operator fun invoke(): Flow<List<Delivery>> = flow {

        emit(
            deliveryRepository.feed()
        )
    }
}