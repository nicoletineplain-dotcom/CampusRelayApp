package com.example.campusrelayapp.ui.settings

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope

import com.example.campusrelayapp.CampusRelayApplication
import com.example.campusrelayapp.R
import com.example.campusrelayapp.datastore.ThemePreferences
import com.example.campusrelayapp.databinding.FragmentSettingsBinding

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SettingsFragment :
    Fragment(R.layout.fragment_settings) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(
            view,
            savedInstanceState
        )

        val binding =
            FragmentSettingsBinding
                .bind(view)

        val application =
            requireActivity()
                .application
                    as CampusRelayApplication

        val preferences =
            ThemePreferences(
                requireContext()
            )

        binding.switchDark.setOnCheckedChangeListener {

                _,
                enabled ->

            lifecycleScope.launch {

                preferences
                    .setDarkMode(
                        enabled
                    )
            }
        }

        binding.btnSignOut.setOnClickListener {

            lifecycleScope.launch {

                application
                    .container
                    .authRepository
                    .signOut()
            }
        }

        lifecycleScope.launch {

            preferences.darkMode
                .collectLatest {

                    binding
                        .switchDark
                        .isChecked = it
                }
        }
    }
}