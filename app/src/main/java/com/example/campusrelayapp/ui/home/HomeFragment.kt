package com.example.campusrelayapp.ui.home

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.campusrelayapp.R
import com.example.campusrelayapp.databinding.FragmentHomeBinding

class HomeFragment :
    Fragment(R.layout.fragment_home) {

    private var _binding:
            FragmentHomeBinding? = null

    private val binding
        get() = _binding!!

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(
            view,
            savedInstanceState
        )

        _binding =
            FragmentHomeBinding.bind(
                view
            )

        binding.btnDelivery.setOnClickListener {

            findNavController()
                .navigate(
                    R.id.action_homeFragment_to_createDeliveryFragment
                )
        }

        binding.btnMarketplace.setOnClickListener {

            findNavController()
                .navigate(
                    R.id.action_homeFragment_to_marketplaceFragment
                )
        }

        binding.btnCarpool.setOnClickListener {

            findNavController()
                .navigate(
                    R.id.action_homeFragment_to_carpoolFragment
                )
        }

        binding.btnQr.setOnClickListener {

            findNavController()
                .navigate(
                    R.id.action_homeFragment_to_qrScannerFragment
                )
        }

        binding.btnLeaderboard.setOnClickListener {

            findNavController()
                .navigate(
                    R.id.action_homeFragment_to_ecoLeaderboardFragment
                )
        }

        binding.btnProfile.setOnClickListener {

            findNavController()
                .navigate(
                    R.id.action_homeFragment_to_profileFragment
                )
        }

        binding.btnSettings.setOnClickListener {

            findNavController()
                .navigate(
                    R.id.action_homeFragment_to_settingsFragment
                )
        }
    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null
    }
}