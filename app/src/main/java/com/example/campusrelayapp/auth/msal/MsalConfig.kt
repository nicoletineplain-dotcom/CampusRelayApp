package com.example.campusrelayapp.auth.msal

object MsalConfig {

    const val CLIENT_ID = "YOUR-APPLICATION-CLIENT-ID"

    const val TENANT_ID = "YOUR-TENANT-ID"

    const val AUTHORITY =
        "https://login.microsoftonline.com/YOUR-TENANT-ID"

    const val REDIRECT_URI =
        "msauth://com.example.campusrelayapp/YOUR_SIGNATURE_HASH"

    val scopes: Array<String> = arrayOf(
        "User.Read"
    )

    fun isConfigured(): Boolean {
        return CLIENT_ID != "YOUR-APPLICATION-CLIENT-ID" &&
                TENANT_ID != "YOUR-TENANT-ID" &&
                REDIRECT_URI !=
                "msauth://com.example.campusrelayapp/YOUR_SIGNATURE_HASH"
    }
}