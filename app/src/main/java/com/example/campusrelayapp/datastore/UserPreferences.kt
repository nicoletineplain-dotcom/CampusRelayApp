package com.example.campusrelayapp.datastore

import android.content.Context

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore

import kotlinx.coroutines.flow.map

private val Context.userDataStore by
preferencesDataStore(
    name = "campus_relay_user"
)

class UserPreferences(
    private val context: Context
) {

    private val loggedInKey =
        booleanPreferencesKey(
            "logged_in"
        )

    val loggedIn =
        context.userDataStore.data.map {

            it[loggedInKey] ?: false
        }

    suspend fun setLoggedIn(
        value: Boolean
    ) {

        context.userDataStore.edit {

            it[loggedInKey] =
                value
        }
    }
}