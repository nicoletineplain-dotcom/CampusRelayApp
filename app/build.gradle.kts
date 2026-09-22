plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // Room KSP
    id("com.google.devtools.ksp")

    // Firebase
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.campusrelayapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.campusrelayapp"
        minSdk = 25
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    // ---------------------------------------------------------
    // AndroidX
    // ---------------------------------------------------------

    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.appcompat:appcompat:1.8.0")
    implementation("androidx.activity:activity-ktx:1.13.0")
    implementation("androidx.fragment:fragment-ktx:1.8.9")

    implementation(
        libs.androidx.lifecycle.runtime.ktx.v2110
    )

    implementation(
        libs.androidx.lifecycle.viewmodel.ktx.v2110
    )

    // ---------------------------------------------------------
    // Material Design
    // ---------------------------------------------------------

    implementation(
        libs.material
    )

    implementation(
        libs.androidx.constraintlayout.v222
    )

    implementation(
        libs.androidx.recyclerview
    )

    // ---------------------------------------------------------
    // Navigation
    // ---------------------------------------------------------

    implementation(
        libs.androidx.navigation.fragment.ktx
    )

    implementation(
        libs.androidx.navigation.ui.ktx
    )

    // ---------------------------------------------------------
    // Room (from old project)
    // ---------------------------------------------------------

    val roomVersion = "2.8.5"

    implementation(
        libs.androidx.room.runtime
    )

    implementation(
        libs.androidx.room.ktx
    )

    ksp(
        libs.androidx.room.compiler
    )

    // ---------------------------------------------------------
    // Retrofit
    // ---------------------------------------------------------

    implementation(
        libs.retrofit
    )

    implementation(
        libs.converter.gson
    )

    implementation(
        libs.logging.interceptor.v550
    )

    // ---------------------------------------------------------
    // Coroutines
    // ---------------------------------------------------------

    implementation(
        libs.kotlinx.coroutines.android.v1110
    )

    // ---------------------------------------------------------
    // WorkManager
    // ---------------------------------------------------------

    implementation(
        libs.androidx.work.runtime.ktx
    )

    // ---------------------------------------------------------
    // DataStore
    // ---------------------------------------------------------

    implementation(
        libs.androidx.datastore.preferences.v121
    )

    // ---------------------------------------------------------
    // Microsoft Entra / MSAL
    // ---------------------------------------------------------

    implementation(
        libs.msal.v850
    )

    // ---------------------------------------------------------
    // Biometrics
    // ---------------------------------------------------------

    implementation(
        libs.androidx.biometric
    )

    // ---------------------------------------------------------
    // Firebase Cloud Messaging
    // ---------------------------------------------------------

    implementation(
        platform(libs.firebase.bom)
    )

    implementation(
        libs.google.firebase.messaging
    )

    // ---------------------------------------------------------
    // QR Scanner
    // ---------------------------------------------------------

    implementation(
        libs.core.v354
    )

    implementation(
        libs.zxing.embedded
    )

    // ---------------------------------------------------------
    // Testing
    // ---------------------------------------------------------

    testImplementation(
        libs.junit
    )

    androidTestImplementation(
        libs.androidx.junit
    )

    androidTestImplementation(
        libs.androidx.espresso.core
    )
}