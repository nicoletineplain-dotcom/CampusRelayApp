package com.example.campusrelayapp.ui.marketplace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.example.campusrelayapp.data.repository.MarketplaceRepository

class MarketplaceViewModel(

    private val repository:
    MarketplaceRepository

) : ViewModel() {

    val listings =
        liveData {

            emit(
                repository.feed()
            )
        }
}