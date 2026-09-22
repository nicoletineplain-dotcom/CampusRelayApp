package com.example.campusrelayapp.domain.usecase

class MatchRouteUseCase {

    operator fun invoke(

        distanceKm: Double,

        radiusKm: Double = 1.0

    ): Boolean {

        return distanceKm <= radiusKm
    }
}