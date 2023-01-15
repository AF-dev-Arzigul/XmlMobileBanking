package com.example.maobilebanking.ui.screens.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maobilebanking.R
import com.example.maobilebanking.databinding.FragmentIntroScreenBinding
import com.example.maobilebanking.ui.screens.intro.impl.IntroScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class IntroScreen : Fragment(R.layout.fragment_intro_screen) {
    private val viewModel : IntroScreenViewModel by viewModels<IntroScreenViewModelImpl>()
    private val binding:FragmentIntroScreenBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel
        binding.nextBtn.setOnClickListener {
          lifecycleScope.launch(){
               viewModel.accept()
          }

        }
    }
}