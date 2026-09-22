package com.example.campusrelayapp.ui.carpool

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.campusrelayapp.R
import com.example.campusrelayapp.databinding.FragmentCreateRideBinding

class CreateRideFragment :
    Fragment(R.layout.fragment_create_ride) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(
            view,
            savedInstanceState
        )

        val binding =
            FragmentCreateRideBinding
                .bind(view)

        binding.btnSubmit.setOnClickListener {

            findNavController()
                .popBackStack()
        }
    }
}