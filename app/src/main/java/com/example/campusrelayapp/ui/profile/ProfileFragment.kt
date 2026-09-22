package com.example.campusrelayapp.ui.profile

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope

import com.example.campusrelayapp.CampusRelayApplication
import com.example.campusrelayapp.R
import com.example.campusrelayapp.databinding.FragmentProfileBinding

import kotlinx.coroutines.launch

class ProfileFragment :
    Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(
            view,
            savedInstanceState
        )

        val binding =
            FragmentProfileBinding
                .bind(view)

        val application =
            requireActivity()
                .application
                    as CampusRelayApplication

        lifecycleScope.launch {

            val user =
                application
                    .container
                    .userRepository
                    .current()

            binding.txtName.text =
                user?.name
                    ?: "CampusRelay Student"

            binding.txtEmail.text =
                user?.email
                    ?: "No account loaded"

            binding.txtEco.text =
                "%.2f kg CO₂ saved"
                    .format(
                        user?.ecoScore ?: 0.0
                    )
        }
    }
}