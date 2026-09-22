package com.example.campusrelayapp.domain.usecase

import android.app.Activity

import com.example.campusrelayapp.data.repository.AuthRepository

class SignInUseCase(

    private val repository:
    AuthRepository

) {

    suspend operator fun invoke(
        activity: Activity
    ): Result<String> {

        return repository.signIn(
            activity
        )
    }
}