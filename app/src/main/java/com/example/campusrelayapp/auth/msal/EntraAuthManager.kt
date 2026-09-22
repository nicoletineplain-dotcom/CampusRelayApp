package com.example.campusrelayapp.auth.msal

import android.app.Activity
import android.content.Context

import com.example.campusrelayapp.R
import com.microsoft.identity.client.AuthenticationCallback
import com.microsoft.identity.client.IAuthenticationResult
import com.microsoft.identity.client.IPublicClientApplication
import com.microsoft.identity.client.ISingleAccountPublicClientApplication
import com.microsoft.identity.client.PublicClientApplication
import com.microsoft.identity.client.SignInParameters
import com.microsoft.identity.client.exception.MsalException


data class AuthAccount(
    val id: String,
    val name: String,
    val email: String
)


class EntraAuthManager(
    private val context: Context
) {

    private var application:
            ISingleAccountPublicClientApplication? = null


    fun initialize(
        onReady: () -> Unit,
        onError: (Exception) -> Unit
    ) {

        PublicClientApplication
            .createSingleAccountPublicClientApplication(
                context,
                R.raw.auth_config_single_account,

                object :
                    IPublicClientApplication
                    .ISingleAccountApplicationCreatedListener {

                    override fun onCreated(
                        app: ISingleAccountPublicClientApplication
                    ) {

                        application = app

                        onReady()
                    }

                    override fun onError(
                        exception: MsalException
                    ) {

                        onError(exception)
                    }
                }
            )
    }


    fun signIn(
        activity: Activity,
        onSuccess: (AuthAccount) -> Unit,
        onError: (Exception) -> Unit
    ) {

        val app = application

        if (app == null) {

            onError(
                IllegalStateException(
                    "MSAL has not been initialized."
                )
            )

            return
        }


        val parameters =
            SignInParameters
                .builder()
                .withActivity(activity)
                .withScopes(
                    MsalConfig.scopes.toList()
                )
                .withCallback(
                    object : AuthenticationCallback {

                        override fun onSuccess(
                            result: IAuthenticationResult
                        ) {

                            val account =
                                result.account

                            onSuccess(
                                AuthAccount(
                                    id = account.id,
                                    name = account.username,
                                    email = account.username
                                )
                            )
                        }


                        override fun onError(
                            exception: MsalException
                        ) {

                            onError(exception)
                        }


                        override fun onCancel() {

                            onError(
                                IllegalStateException(
                                    "Sign-in cancelled."
                                )
                            )
                        }
                    }
                )
                .build()


        app.signIn(parameters)
    }


    fun signOut(
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit
    ) {

        val app = application

        if (app == null) {

            onSuccess()

            return
        }


        app.signOut(
            object :
                ISingleAccountPublicClientApplication
                .SignOutCallback {

                override fun onSignOut() {

                    onSuccess()
                }

                override fun onError(
                    exception: MsalException
                ) {

                    onError(exception)
                }
            }
        )
    }
}