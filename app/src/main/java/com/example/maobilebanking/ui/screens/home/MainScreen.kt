package com.example.maobilebanking.ui.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maobilebanking.R
import com.example.maobilebanking.databinding.ScreenMainBinding
import com.example.maobilebanking.ui.screens.home.impl.MainScreenViewModelImpl

class MainScreen : Fragment(R.layout.screen_main) {
    private val binding: ScreenMainBinding by viewBinding()
    private val viewModel: MainScreenViewModel by viewModels<MainScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}