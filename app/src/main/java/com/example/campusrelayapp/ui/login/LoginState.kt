package com.example.campusrelayapp.ui.login

data class LoginState(

    val loading: Boolean = false,

    val signedIn: Boolean = false,

    val error: String? = null
)