package com.example.campusrelayapp.data.repository

import android.app.Activity

import com.example.campusrelayapp.auth.msal.EntraAuthManager
import com.example.campusrelayapp.data.local.dao.UserDao
import com.example.campusrelayapp.data.local.entity.UserEntity
import kotlinx.coroutines.launch

import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class AuthRepository(

    private val authManager:
    EntraAuthManager,

    private val userDao:
    UserDao

) {

    suspend fun signIn(
        activity: Activity
    ): Result<String> =
        suspendCancellableCoroutine { continuation ->

            authManager.signIn(

                activity = activity,

                onSuccess = { account ->

                    /*
                     * Save authenticated user locally.
                     */
                    kotlinx.coroutines.CoroutineScope(
                        kotlinx.coroutines.Dispatchers.IO
                    ).launch {

                        userDao.upsert(

                            UserEntity(

                                id =
                                    account.id,

                                name =
                                    account.name,

                                email =
                                    account.email,

                                studentNumber =
                                    null,

                                ecoScore =
                                    0.0
                            )
                        )

                        continuation.resume(
                            Result.success(
                                account.id
                            )
                        )
                    }
                },

                onError = {

                    continuation.resume(
                        Result.failure(it)
                    )
                }
            )
        }

    suspend fun signOut() =
        suspendCancellableCoroutine<Unit> {

                continuation ->

            authManager.signOut(

                onSuccess = {

                    kotlinx.coroutines
                        .CoroutineScope(
                            kotlinx.coroutines.Dispatchers.IO
                        )
                        .launch {

                            userDao.clear()

                            continuation.resume(
                                Unit
                            )
                        }
                },

                onError = {

                    continuation.resume(
                        Unit
                    )
                }
            )
        }
}