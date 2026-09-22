package com.example.campusrelayapp.domain.usecase

import com.example.campusrelayapp.data.repository.DeliveryRepository
import com.example.campusrelayapp.domain.model.Delivery

/**
 * Use case for creating a new delivery.
 */
class CreateDeliveryUseCase(
    private val deliveryRepository: DeliveryRepository
) {

    /**
     * Creates a delivery through the repository.
     */
    suspend operator fun invoke(
        id: String,
        requesterId: String,
        pickup: String,
        dropoff: String,
        price: Double
    ): Result<Delivery> {

        val delivery = Delivery(

            id = id,

            requesterId = requesterId,

            pickup = pickup,

            dropoff = dropoff,

            status = "PENDING",

            price = price
        )

        return deliveryRepository.create(
            delivery
        )
    }
}