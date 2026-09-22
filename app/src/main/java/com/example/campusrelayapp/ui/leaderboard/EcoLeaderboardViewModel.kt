package com.example.campusrelayapp.ui.leaderboard

import androidx.lifecycle.ViewModel

import com.example.campusrelayapp.domain.model.EcoScore

class EcoLeaderboardViewModel :
    ViewModel() {

    val scores =
        listOf(

            EcoScore(
                userId = "1",
                co2SavedKg = 42.8,
                rank = 1,
                badge = "Campus Eco-Hero"
            ),

            EcoScore(
                userId = "2",
                co2SavedKg = 31.4,
                rank = 2,
                badge = "Top Courier"
            ),

            EcoScore(
                userId = "3",
                co2SavedKg = 26.1,
                rank = 3,
                badge = "Zero Drop"
            )
        )
}