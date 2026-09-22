package com.example.campusrelayapp.ui.login

import android.app.Activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.campusrelayapp.data.repository.AuthRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _state =
        MutableStateFlow(LoginState())

    val state: StateFlow<LoginState> =
        _state

    fun signIn(activity: Activity) {

        viewModelScope.launch {

            _state.value =
                LoginState(loading = true)

            val result =
                authRepository.signIn(activity)

            _state.value =
                result.fold(

                    onSuccess = {
                        LoginState(
                            signedIn = true
                        )
                    },

                    onFailure = {
                        LoginState(
                            error =
                                it.message
                                    ?: "Unable to sign in."
                        )
                    }
                )
        }
    }
}