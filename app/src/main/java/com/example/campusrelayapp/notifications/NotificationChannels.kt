package com.example.campusrelayapp.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

object NotificationChannels {

    const val GENERAL =
        "campus_relay_general"

    const val DELIVERY =
        "campus_relay_delivery"

    fun create(
        context: Context
    ) {

        if (
            Build.VERSION.SDK_INT <
            Build.VERSION_CODES.O
        ) {
            return
        }

        val manager =
            context.getSystemService(
                NotificationManager::class.java
            )

        val general =
            NotificationChannel(

                GENERAL,

                "CampusRelay",

                NotificationManager
                    .IMPORTANCE_DEFAULT
            )

        val delivery =
            NotificationChannel(

                DELIVERY,

                "Delivery updates",

                NotificationManager
                    .IMPORTANCE_HIGH
            )

        manager.createNotificationChannel(
            general
        )

        manager.createNotificationChannel(
            delivery
        )
    }
}