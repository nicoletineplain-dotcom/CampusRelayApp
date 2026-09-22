package com.example.campusrelayapp.data.remote.api

import com.example.campusrelayapp.util.Constants

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    fun create(): ApiService {

        val logging =
            HttpLoggingInterceptor().apply {

                level =
                    HttpLoggingInterceptor
                        .Level.BASIC
            }

        val client =
            OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

        return Retrofit.Builder()

            .baseUrl(
                Constants.BASE_URL
            )

            .client(client)

            .addConverterFactory(
                GsonConverterFactory.create()
            )

            .build()

            .create(
                ApiService::class.java
            )
    }
}