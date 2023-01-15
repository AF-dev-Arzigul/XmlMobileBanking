package com.example.maobilebanking.ui.screens.auth.signin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maobilebanking.R
import com.example.maobilebanking.databinding.FragmentLoginScreenBinding
import com.example.maobilebanking.ui.screens.auth.signin.impl.LoginScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login_screen.*
import kotlinx.android.synthetic.main.fragment_sign_up_screen.*
import kotlinx.android.synthetic.main.fragment_sign_up_screen.input_phone
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.fragment_login_screen) {
    private val binding: FragmentLoginScreenBinding by viewBinding()
    private val viewModel: LoginScreenViewModel by viewModels<LoginScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.toRegister.setOnClickListener {
            viewModel.openSignUpScreen()
        }

        binding.toSignIn.setOnClickListener {
            val phone = binding.inputPhone.text.toString()
            val password = binding.inputPassword.text.toString()
            viewModel.login(phone, password)
        }

        viewModel.error.onEach {

        }.launchIn(lifecycleScope)

        viewModel.loading.onEach {

        }.launchIn(lifecycleScope)

    }

}