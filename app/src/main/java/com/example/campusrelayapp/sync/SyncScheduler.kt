package com.example.campusrelayapp.sync

import android.content.Context

import androidx.work.*

import java.util.concurrent.TimeUnit

object SyncScheduler {

    private const val WORK_NAME =
        "campus_relay_offline_sync"

    fun schedule(
        context: Context
    ) {

        val constraints =
            Constraints.Builder()

                .setRequiredNetworkType(
                    NetworkType.CONNECTED
                )

                .build()

        val request =
            PeriodicWorkRequestBuilder<
                    OfflineSyncWorker
                    >(
                15,
                TimeUnit.MINUTES
            )

                .setConstraints(
                    constraints
                )

                .build()

        WorkManager
            .getInstance(context)
            .enqueueUniquePeriodicWork(

                WORK_NAME,

                ExistingPeriodicWorkPolicy.UPDATE,

                request
            )
    }
}