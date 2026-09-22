package com.example.campusrelayapp.domain.usecase

import com.example.campusrelayapp.data.repository.CarpoolRepository
import com.example.campusrelayapp.domain.model.RideOffer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Gets available carpool rides.
 */
class GetRideOffersUseCase(
    private val carpoolRepository: CarpoolRepository
) {

    /**
     * Returns available rides as a Flow.
     */
    operator fun invoke(): Flow<List<RideOffer>> = flow {

        val rides = carpoolRepository.feed()

        emit(
            rides.map { ride ->

                RideOffer(
                    id = ride.id,
                    driverId = ride.driverId,
                    origin = ride.origin,
                    destination = ride.destination,
                    seats = ride.seats,
                    pricePerSeat = ride.pricePerSeat,
                    status = ride.status
                )
            }
        )
    }
}