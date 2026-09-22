package com.example.campusrelayapp.notifications

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager

import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import com.example.campusrelayapp.R

object NotificationHelper {

    fun show(

        context: Context,

        title: String,

        body: String,

        delivery: Boolean = false

    ) {

        if (
            android.os.Build.VERSION.SDK_INT >= 33 &&
            context.checkSelfPermission(
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        val channel =
            if (delivery)
                NotificationChannels.DELIVERY
            else
                NotificationChannels.GENERAL

        val notification =
            NotificationCompat
                .Builder(
                    context,
                    channel
                )

                .setSmallIcon(
                    R.drawable.ic_notification
                )

                .setContentTitle(
                    title
                )

                .setContentText(
                    body
                )

                .setAutoCancel(true)

                .setPriority(
                    if (delivery)
                        NotificationCompat.PRIORITY_HIGH
                    else
                        NotificationCompat.PRIORITY_DEFAULT
                )

                .build()

        NotificationManagerCompat
            .from(context)
            .notify(
                (System.currentTimeMillis() % 100000)
                    .toInt(),
                notification
            )
    }
}