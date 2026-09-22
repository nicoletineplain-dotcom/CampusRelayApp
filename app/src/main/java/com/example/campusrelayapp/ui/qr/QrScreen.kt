package com.example.campusrelayapp.ui.qr

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * QR screen.
 *
 * The actual QR generation/scanning functionality can
 * be connected later.
 */
@Composable
fun QrScreen(
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Campus QR",
            style = MaterialTheme.typography.headlineMedium
        )

        Card(
            modifier = Modifier.padding(30.dp)
        ) {

            Column(
                modifier = Modifier.padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "QR CODE",
                    style =
                        MaterialTheme.typography.headlineSmall
                )

                Text(
                    text =
                        "Your QR code will appear here."
                )
            }
        }

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Back")
        }
    }
}