package com.example.campusrelayapp.ui.delivery

import androidx.lifecycle.*
import com.example.campusrelayapp.data.repository.DeliveryRepository

class DeliveryViewModel(
    private val repository:
    DeliveryRepository
) : ViewModel() {

    val deliveries =
        liveData {

            emit(
                repository.feed()
            )
        }
}