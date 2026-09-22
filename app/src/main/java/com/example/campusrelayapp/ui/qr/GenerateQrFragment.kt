package com.example.campusrelayapp.ui.qr

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment

import com.example.campusrelayapp.R
import com.example.campusrelayapp.databinding.FragmentGenerateQrBinding

import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter

class GenerateQrFragment :
    Fragment(R.layout.fragment_generate_qr) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(
            view,
            savedInstanceState
        )

        val binding =
            FragmentGenerateQrBinding
                .bind(view)

        val payload =
            QrViewModel()
                .createPayload(
                    "delivery-demo"
                )

        val matrix =
            MultiFormatWriter()
                .encode(

                    payload,

                    BarcodeFormat.QR_CODE,

                    700,

                    700
                )

        val bitmap =
            Bitmap.createBitmap(

                700,

                700,

                Bitmap.Config.RGB_565
            )

        for (x in 0 until 700) {

            for (y in 0 until 700) {

                bitmap.setPixel(

                    x,

                    y,

                    if (matrix[x, y])
                        android.graphics.Color.BLACK
                    else
                        android.graphics.Color.WHITE
                )
            }
        }

        binding.qrImage
            .setImageBitmap(
                bitmap
            )
    }
}