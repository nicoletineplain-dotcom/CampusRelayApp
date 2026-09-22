package com.example.campusrelayapp.datastore

import android.content.Context

import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore

import kotlinx.coroutines.flow.map

private val Context.ecoDataStore by
preferencesDataStore(
    name = "campus_relay_eco"
)

class EcoScorePreferences(
    private val context: Context
) {

    private val scoreKey =
        doublePreferencesKey(
            "eco_score"
        )

    val score =
        context.ecoDataStore.data.map {

            it[scoreKey] ?: 0.0
        }

    suspend fun addScore(
        value: Double
    ) {

        context.ecoDataStore.edit {

            it[scoreKey] =
                (it[scoreKey] ?: 0.0) + value
        }
    }
}