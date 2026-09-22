package com.example.campusrelayapp.auth

/**
 * Represents the possible authentication states.
 */
sealed class AuthResult {

    /**
     * Authentication is currently running.
     */
    data object Loading : AuthResult()

    /**
     * Authentication completed successfully.
     */
    data class Success(
        val accessToken: String,
        val idToken: String?,
        val username: String?
    ) : AuthResult()

    /**
     * Authentication failed.
     */
    data class Error(
        val message: String
    ) : AuthResult()

    /**
     * User cancelled the authentication process.
     */
    data object Cancelled : AuthResult()
}