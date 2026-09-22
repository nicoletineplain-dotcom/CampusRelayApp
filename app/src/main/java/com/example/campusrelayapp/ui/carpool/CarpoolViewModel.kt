package com.example.campusrelayapp.ui.carpool

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class RideUiItem(

    val route: String,

    val meta: String,

    val driver: String

)


class CarpoolViewModel : ViewModel() {

    private val _rides =
        MutableStateFlow(

            listOf(

                RideUiItem(
                    "University Entrance → Campus Library",
                    "Today · 08:00 · 2 seats",
                    "Student driver"
                ),

                RideUiItem(
                    "Residence → Student Union",
                    "Today · 09:30 · 1 seat",
                    "Student driver"
                )

            )

        )

    val rides: StateFlow<List<RideUiItem>> =
        _rides
}