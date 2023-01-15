package com.example.maobilebanking.ui.screens.splashscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maobilebanking.R
import com.example.maobilebanking.databinding.FragmentSplashScreenBinding
import com.example.maobilebanking.ui.screens.splashscreen.impl.SplashScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.fragment_splash_screen) {
    private val viewModel: SplashScreenViewModel by viewModels<SplashScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel
    }

}