package com.example.campusrelayapp.sync

import android.content.Context

import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

import com.example.campusrelayapp.CampusRelayApplication

class OfflineSyncWorker(

    context: Context,

    params: WorkerParameters

) : CoroutineWorker(
    context,
    params
) {

    override suspend fun doWork():
            Result {

        val app =
            applicationContext
                    as CampusRelayApplication

        val result =
            app.container
                .deliveryRepository
                .syncOffline()

        return if (
            result.isSuccess
        ) {
            Result.success()
        } else {
            Result.retry()
        }
    }
}