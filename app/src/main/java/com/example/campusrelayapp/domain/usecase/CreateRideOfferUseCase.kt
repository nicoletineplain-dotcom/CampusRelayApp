package com.example.campusrelayapp.domain.usecase

import com.example.campusrelayapp.data.remote.dto.RideOfferDto
import com.example.campusrelayapp.data.repository.CarpoolRepository
import com.example.campusrelayapp.domain.model.RideOffer

class CreateRideOfferUseCase(
    private val carpoolRepository: CarpoolRepository
) {

    suspend operator fun invoke(
        driverId: String,
        origin: String,
        destination: String,
        seats: Int,
        pricePerSeat: Double
    ): Result<RideOffer> {

        val ride = RideOfferDto(
            id = "",
            driverId = driverId,
            origin = origin,
            destination = destination,
            seats = seats,
            pricePerSeat = pricePerSeat,
            status = "ACTIVE"
        )

        return carpoolRepository.createRide(ride).map { entity ->

            RideOffer(
                id = entity.id,
                driverId = entity.driverId,
                origin = entity.origin,
                destination = entity.destination,
                seats = entity.seats,
                pricePerSeat = entity.pricePerSeat,
                status = entity.status
            )
        }
    }
}