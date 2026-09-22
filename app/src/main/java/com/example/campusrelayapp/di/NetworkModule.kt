package com.example.campusrelayapp.di

import com.example.campusrelayapp.data.remote.api.ApiService
import com.example.campusrelayapp.data.remote.api.RetrofitProvider

object NetworkModule {

    fun provideApi():
            ApiService {

        return RetrofitProvider
            .create()
    }
}