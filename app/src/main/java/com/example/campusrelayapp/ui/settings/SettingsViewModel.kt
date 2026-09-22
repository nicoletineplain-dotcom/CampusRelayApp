package com.example.campusrelayapp.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.campusrelayapp.datastore.ThemePreferences

import kotlinx.coroutines.launch

class SettingsViewModel(

    private val preferences:
    ThemePreferences

) : ViewModel() {

    fun setDarkMode(
        enabled: Boolean
    ) {

        viewModelScope.launch {

            preferences
                .setDarkMode(
                    enabled
                )
        }
    }
}