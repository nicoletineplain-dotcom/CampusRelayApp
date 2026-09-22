package com.example.campusrelayapp.ui.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ProfileUiState(

    val name: String = "Campus Student",

    val deliveries: Int = 12,

    val rides: Int = 5,

    val listings: Int = 8

)


class ProfileViewModel : ViewModel() {

    private val _state =
        MutableStateFlow(
            ProfileUiState()
        )

    val state: StateFlow<ProfileUiState> =
        _state
}