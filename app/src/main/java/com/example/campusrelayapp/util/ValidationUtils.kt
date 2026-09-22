package com.example.campusrelayapp.util

object ValidationUtils {

    fun isCampusEmail(
        email: String
    ): Boolean {

        return email
            .trim()
            .lowercase()
            .endsWith(".ac.za")
    }

    fun isRequired(
        value: String
    ): Boolean {

        return value
            .trim()
            .isNotEmpty()
    }

    fun isPositive(
        value: Double
    ): Boolean {

        return value > 0
    }
}