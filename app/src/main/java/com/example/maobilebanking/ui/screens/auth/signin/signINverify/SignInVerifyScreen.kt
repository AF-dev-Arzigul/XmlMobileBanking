package com.example.maobilebanking.ui.screens.auth.signin.signINverify

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maobilebanking.R
import com.example.maobilebanking.databinding.FragmentSigninVerifyScreenBinding
import com.example.maobilebanking.model.remote.request.SignInVerifyRequest
import com.example.maobilebanking.ui.screens.auth.signin.signINverify.impl.SignInVerifyScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignInVerifyScreen : Fragment(R.layout.fragment_signin_verify_screen) {
    private val binding: FragmentSigninVerifyScreenBinding by viewBinding()
    private val args: SignInVerifyScreenArgs by navArgs()
    private val viewModel: SignInVerifyScreenViewModel by viewModels<SignInVerifyScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.checkBtnsignIn.setOnClickListener {
            val code = binding.verifySmsCode.enteredCode
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.check(SignInVerifyRequest(args.token, code))
            }
        }


    }
}
