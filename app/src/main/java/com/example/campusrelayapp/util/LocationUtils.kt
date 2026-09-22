package com.example.campusrelayapp.util

import kotlin.math.*

object LocationUtils {

    fun distanceKm(

        latitude1: Double,

        longitude1: Double,

        latitude2: Double,

        longitude2: Double

    ): Double {

        val earthRadius =
            6371.0

        val dLat =
            Math.toRadians(
                latitude2 - latitude1
            )

        val dLon =
            Math.toRadians(
                longitude2 - longitude1
            )

        val a =
            sin(dLat / 2).pow(2) +

                    cos(
                        Math.toRadians(
                            latitude1
                        )
                    ) *

                    cos(
                        Math.toRadians(
                            latitude2
                        )
                    ) *

                    sin(dLon / 2).pow(2)

        return 2 *
                earthRadius *
                asin(
                    sqrt(a)
                )
    }
}