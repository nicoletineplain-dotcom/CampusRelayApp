package com.example.campusrelayapp.ui.leaderboard

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment

import com.example.campusrelayapp.R
import com.example.campusrelayapp.databinding.FragmentEcoLeaderboardBinding

class EcoLeaderboardFragment :
    Fragment(
        R.layout.fragment_eco_leaderboard
    ) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(
            view,
            savedInstanceState
        )

        val binding =
            FragmentEcoLeaderboardBinding
                .bind(view)

        val viewModel =
            EcoLeaderboardViewModel()

        binding.txtLeaderboard.text =
            viewModel.scores.joinToString(
                separator = "\n\n"
            ) {

                "${it.rank}. " +
                        "${it.badge}\n" +
                        "${it.co2SavedKg} kg CO₂ saved"
            }
    }
}