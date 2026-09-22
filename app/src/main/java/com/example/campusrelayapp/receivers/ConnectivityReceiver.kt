package com.example.campusrelayapp.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

import com.example.campusrelayapp.sync.SyncScheduler

class ConnectivityReceiver :
    BroadcastReceiver() {

    override fun onReceive(
        context: Context,
        intent: Intent?
    ) {

        /*
         * When connectivity returns, schedule
         * the offline queue for synchronisation.
         */
        SyncScheduler.schedule(
            context.applicationContext
        )
    }
}