// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    // Version catalog plugins
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.ksp) apply false

    // Kotlin KAPT
    id("org.jetbrains.kotlin.kapt") version "2.2.20" apply false

    // Firebase Google Services
    id("com.google.gms.google-services") version "4.5.0" apply false
}