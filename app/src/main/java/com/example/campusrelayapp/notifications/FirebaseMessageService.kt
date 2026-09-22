package com.example.campusrelayapp.notifications

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessageService :
    FirebaseMessagingService() {

    override fun onMessageReceived(
        message: RemoteMessage
    ) {

        val title =
            message.data["title"]
                ?: message.notification?.title
                ?: "CampusRelay"

        val body =
            message.data["body"]
                ?: message.notification?.body
                ?: "You have a new update."

        NotificationHelper.show(

            context = this,

            title = title,

            body = body,

            delivery = true
        )
    }

    override fun onNewToken(
        token: String
    ) {

        super.onNewToken(token)

        /*
         * TODO:
         *
         * Send this token to your CampusRelay backend.
         */
    }
}