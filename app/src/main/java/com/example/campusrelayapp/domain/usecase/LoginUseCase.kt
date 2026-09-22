package com.example.campusrelayapp.domain.usecase

import android.app.Activity

import com.example.campusrelayapp.data.repository.AuthRepository

/**
 * Use case responsible for signing a user into CampusRelay.
 */
class LoginUseCase(
    private val authRepository: AuthRepository
) {

    /**
     * Executes the sign-in operation.
     */
    suspend operator fun invoke(
        activity: Activity
    ): Result<String> {

        return authRepository.signIn(activity)
    }
}