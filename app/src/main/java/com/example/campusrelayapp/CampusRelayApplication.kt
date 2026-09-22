package com.example.campusrelayapp

import android.app.Application

import com.example.campusrelayapp.di.AppContainer
import com.example.campusrelayapp.notifications.NotificationChannels
import com.example.campusrelayapp.sync.SyncScheduler

class CampusRelayApplication :
    Application() {

    lateinit var container:
            AppContainer

    override fun onCreate() {

        super.onCreate()

        /*
         * Dependency container.
         */
        container =
            AppContainer(this)

        /*
         * Notification channels must exist
         * before notifications are posted.
         */
        NotificationChannels
            .create(this)

        /*
         * Start periodic offline synchronisation.
         */
        SyncScheduler
            .schedule(this)
    }
}