package com.example.campusrelayapp.ui.carpool

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.campusrelayapp.R
import com.example.campusrelayapp.databinding.FragmentCarpoolBinding

class CarpoolFragment :
    Fragment(R.layout.fragment_carpool) {

    private var _binding:
            FragmentCarpoolBinding? = null

    private val binding
        get() = _binding!!

    private val viewModel:
            CarpoolViewModel by viewModels()

    private val adapter =
        RideOfferAdapter()


    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        _binding =
            FragmentCarpoolBinding.bind(view)


        binding.recyclerRides.layoutManager =
            LinearLayoutManager(
                requireContext()
            )


        binding.recyclerRides.adapter =
            adapter


        adapter.submitList(
            viewModel.rides.value
        )
    }


    override fun onDestroyView() {

        _binding = null

        super.onDestroyView()
    }
}