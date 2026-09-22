package com.example.campusrelayapp.auth.biometric

import android.content.Context

import androidx.biometric.BiometricManager.Authenticators
import androidx.biometric.BiometricManager as AndroidBiometricManager

class BiometricManager(
    private val context: Context
) {

    fun canAuthenticate(): Boolean {

        val manager =
            AndroidBiometricManager
                .from(context)

        val result =
            manager.canAuthenticate(
                Authenticators.BIOMETRIC_STRONG or
                        Authenticators.DEVICE_CREDENTIAL
            )

        return result ==
                AndroidBiometricManager.BIOMETRIC_SUCCESS
    }
}