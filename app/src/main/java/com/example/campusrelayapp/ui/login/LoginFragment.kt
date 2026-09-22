package com.example.campusrelayapp.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import com.example.campusrelayapp.CampusRelayApplication
import com.example.campusrelayapp.R
import com.example.campusrelayapp.auth.biometric.BiometricAuthenticator
import com.example.campusrelayapp.databinding.FragmentLoginBinding

import kotlinx.coroutines.launch

class LoginFragment :
    Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null

    private val binding
        get() = _binding!!

    private lateinit var viewModel: LoginViewModel

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(
            view,
            savedInstanceState
        )

        _binding =
            FragmentLoginBinding.bind(view)

        val application =
            requireActivity()
                .application as CampusRelayApplication

        viewModel =
            ViewModelProvider(
                this,
                object : ViewModelProvider.Factory {

                    override fun <T : ViewModel>
                            create(
                        modelClass: Class<T>
                    ): T {

                        return LoginViewModel(
                            application
                                .container
                                .authRepository
                        ) as T
                    }
                }
            )[LoginViewModel::class.java]

        /*
         * Microsoft Entra SSO
         */
        binding.btnSignIn.setOnClickListener {

            viewModel.signIn(
                requireActivity()
            )
        }

        /*
         * Biometric verification
         */
        binding.btnBiometric.setOnClickListener {

            BiometricAuthenticator(
                requireActivity()
            ).authenticate(

                onSuccess = {

                    findNavController()
                        .navigate(
                            R.id.action_loginFragment_to_homeFragment
                        )
                },

                onFailure = { message ->

                    Toast.makeText(
                        requireContext(),
                        message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        }

        /*
         * Observe login state
         */
        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.state.collect { state ->

                binding.progress.visibility =
                    if (state.loading) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }

                if (state.error != null) {

                    Toast.makeText(
                        requireContext(),
                        state.error,
                        Toast.LENGTH_LONG
                    ).show()
                }

                if (
                    state.signedIn &&
                    findNavController()
                        .currentDestination
                        ?.id == R.id.loginFragment
                ) {

                    findNavController()
                        .navigate(
                            R.id.action_loginFragment_to_homeFragment
                        )
                }
            }
        }
    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null
    }
}