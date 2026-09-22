package com.example.campusrelayapp.datastore

import android.content.Context

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore

import kotlinx.coroutines.flow.map

private val Context.themeDataStore by
preferencesDataStore(
    name = "campus_relay_theme"
)

class ThemePreferences(
    private val context: Context
) {

    private val darkModeKey =
        booleanPreferencesKey(
            "dark_mode"
        )

    val darkMode =
        context.themeDataStore.data.map {

            it[darkModeKey] ?: false
        }

    suspend fun setDarkMode(
        enabled: Boolean
    ) {

        context.themeDataStore.edit {

            it[darkModeKey] =
                enabled
        }
    }
}