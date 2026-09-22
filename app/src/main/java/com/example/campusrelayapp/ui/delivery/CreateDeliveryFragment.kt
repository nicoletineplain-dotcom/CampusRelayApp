package com.example.campusrelayapp.ui.delivery

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import com.example.campusrelayapp.CampusRelayApplication
import com.example.campusrelayapp.R
import com.example.campusrelayapp.databinding.FragmentCreateDeliveryBinding
import com.example.campusrelayapp.domain.model.Delivery

import kotlinx.coroutines.launch

import java.util.UUID

class CreateDeliveryFragment :
    Fragment(R.layout.fragment_create_delivery) {

    private var _binding:
            FragmentCreateDeliveryBinding? = null

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
            FragmentCreateDeliveryBinding
                .bind(view)

        val application =
            requireActivity()
                .application as CampusRelayApplication

        binding.btnSubmit.setOnClickListener {

            val pickup =
                binding.inputPickup
                    .text
                    ?.toString()
                    ?.trim()
                    ?: ""

            val dropoff =
                binding.inputDropoff
                    .text
                    ?.toString()
                    ?.trim()
                    ?: ""

            val price =
                binding.inputPrice
                    .text
                    ?.toString()
                    ?.toDoubleOrNull()
                    ?: 0.0

            if (
                pickup.isBlank() ||
                dropoff.isBlank()
            ) {

                return@setOnClickListener
            }

            val delivery =
                Delivery(

                    id =
                        UUID.randomUUID()
                            .toString(),

                    requesterId =
                        "current-user",

                    pickup =
                        pickup,

                    dropoff =
                        dropoff,

                    status =
                        "PENDING",

                    price =
                        price,

                    ecoKg =
                        0.0
                )

            lifecycleScope.launch {

                application
                    .container
                    .deliveryRepository
                    .create(delivery)

                findNavController()
                    .popBackStack()
            }
        }
    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null
    }
}