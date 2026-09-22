package com.example.campusrelayapp.auth.biometric

import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

class BiometricAuthenticator(
    private val activity: FragmentActivity
) {

    fun authenticate(
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

        val executor =
            ContextCompat.getMainExecutor(
                activity
            )

        val callback =
            object :
                BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationSucceeded(
                    result:
                    BiometricPrompt.AuthenticationResult
                ) {

                    onSuccess()
                }

                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {

                    onFailure(
                        errString.toString()
                    )
                }

                override fun onAuthenticationFailed() {

                    onFailure(
                        "Biometric verification failed."
                    )
                }
            }

        val prompt =
            BiometricPrompt(
                activity,
                executor,
                callback
            )

        val information =
            BiometricPrompt.PromptInfo
                .Builder()

                .setTitle(
                    "CampusRelay verification"
                )

                .setSubtitle(
                    "Confirm your identity"
                )

                .setNegativeButtonText(
                    "Cancel"
                )

                .build()

        prompt.authenticate(
            information
        )
    }
}