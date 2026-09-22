package com.example.campusrelayapp.ui.qr

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment

import com.example.campusrelayapp.R
import com.example.campusrelayapp.databinding.FragmentQrScannerBinding

class QrScannerFragment :
    Fragment(R.layout.fragment_qr_scanner) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(
            view,
            savedInstanceState
        )

        val binding =
            FragmentQrScannerBinding
                .bind(view)

        binding.btnScan.setOnClickListener {

            /*
             * Connect JourneyApps / CameraX scanner
             * here for the final camera implementation.
             */
        }
    }
}