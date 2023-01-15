package com.example.maobilebanking.ui.screens.auth.signin.verify

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maobilebanking.R
import com.example.maobilebanking.databinding.FragmentSignupVerifyScreenBinding
import com.example.maobilebanking.model.remote.request.SignUpVerifyRequest
import com.example.maobilebanking.ui.screens.auth.signin.verify.impl.SignUpVerifyScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpVerifyScreen : Fragment(R.layout.fragment_signup_verify_screen) {
    private val binding: FragmentSignupVerifyScreenBinding by viewBinding()
    private val args: SignUpVerifyScreenArgs by navArgs()
    private val viewModel: SignUpVerifyScreenViewModel by viewModels<SignUpVerifyScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.btnCheck.setOnClickListener {
            val code = binding.smsCodeView.enteredCode
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.check(SignUpVerifyRequest(args.token, code))
            }
        }

    }

}