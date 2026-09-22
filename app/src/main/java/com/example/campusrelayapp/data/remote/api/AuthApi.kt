package com.example.campusrelayapp.data.remote.api

import com.example.campusrelayapp.data.remote.dto.AuthRequest
import com.example.campusrelayapp.data.remote.dto.AuthResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Authentication API.
 */
interface AuthApi {

    /**
     * Login endpoint.
     *
     * POST /api/auth/login
     */
    @POST("api/auth/login")
    suspend fun login(
        @Body request: AuthRequest
    ): Response<AuthResponse>
}