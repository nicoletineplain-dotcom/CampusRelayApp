package com.example.campusrelayapp.domain.usecase

class CalculateEcoScoreUseCase {

    fun calculate(

        distanceKm: Double,

        transportMode: String

    ): Double {

        val factor =
            when (
                transportMode.uppercase()
            ) {

                "WALK" ->
                    0.21

                "CYCLE" ->
                    0.18

                "CARPOOL" ->
                    0.09

                else ->
                    0.0
            }

        return (
                distanceKm * factor
                ).coerceAtLeast(0.0)
    }
}