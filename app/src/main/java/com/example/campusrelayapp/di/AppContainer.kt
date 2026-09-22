package com.example.campusrelayapp.di

import android.content.Context

import com.example.campusrelayapp.auth.msal.EntraAuthManager
import com.example.campusrelayapp.data.local.AppDatabase
import com.example.campusrelayapp.data.remote.api.ApiService
import com.example.campusrelayapp.data.remote.api.RetrofitProvider
import com.example.campusrelayapp.data.repository.*

class AppContainer(
    context: Context
) {

    val database:
            AppDatabase =
        DatabaseModule
            .provideDatabase(
                context
            )

    val api:
            ApiService =
        NetworkModule
            .provideApi()

    val entraAuth =
        EntraAuthManager(
            context
        )

    val authRepository =
        AuthRepository(
            entraAuth,
            database.userDao()
        )

    val userRepository =
        UserRepository(
            database.userDao()
        )

    val deliveryRepository =
        DeliveryRepository(
            api,
            database.deliveryDao()
        )

    val marketplaceRepository =
        MarketplaceRepository(
            api,
            database.marketplaceDao()
        )

    val carpoolRepository =
        CarpoolRepository(
            api,
            database.rideOfferDao()
        )

    val offlineSyncRepository =
        OfflineSyncRepository(
            database.offlineTransactionDao()
        )
}