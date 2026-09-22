package com.example.campusrelayapp.ui.qr

import androidx.lifecycle.ViewModel

import java.util.UUID

class QrViewModel :
    ViewModel() {

    fun createPayload(
        transactionId: String
    ): String {

        return buildString {

            append("CAMPUSRELAY|")

            append(transactionId)

            append("|")

            append(
                UUID.randomUUID()
            )
        }
    }
}