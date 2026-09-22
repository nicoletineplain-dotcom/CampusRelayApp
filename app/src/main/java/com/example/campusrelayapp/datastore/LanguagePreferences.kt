package com.example.campusrelayapp.datastore

import android.content.Context

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

import kotlinx.coroutines.flow.map

private val Context.languageDataStore by
preferencesDataStore(
    name = "campus_relay_language"
)

class LanguagePreferences(
    private val context: Context
) {

    private val languageKey =
        stringPreferencesKey(
            "language"
        )

    val language =
        context.languageDataStore.data.map {

            it[languageKey] ?: "en"
        }

    suspend fun setLanguage(
        language: String
    ) {

        context.languageDataStore.edit {

            it[languageKey] =
                language
        }
    }
}