package com.example.campusrelayapp.ui.marketplace

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.campusrelayapp.CampusRelayApplication
import com.example.campusrelayapp.R
import com.example.campusrelayapp.databinding.FragmentMarketplaceBinding

class MarketplaceFragment :
    Fragment(R.layout.fragment_marketplace) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(
            view,
            savedInstanceState
        )

        val binding =
            FragmentMarketplaceBinding
                .bind(view)

        val application =
            requireActivity()
                .application
                    as CampusRelayApplication

        val viewModel =
            ViewModelProvider(
                this,
                object :
                    ViewModelProvider.Factory {

                    override fun <T : ViewModel>
                            create(
                        modelClass:
                        Class<T>
                    ): T {

                        return MarketplaceViewModel(
                            application
                                .container
                                .marketplaceRepository
                        ) as T
                    }

                }
            )[MarketplaceViewModel::class.java]

        val adapter =
            MarketplaceAdapter()

        binding.recycler.adapter =
            adapter

        binding.fab.setOnClickListener {

            findNavController()
                .navigate(
                    R.id.action_marketplaceFragment_to_createListingFragment
                )
        }

        viewModel.listings.observe(
            viewLifecycleOwner
        ) {

            adapter.submitList(it)
        }
    }
}