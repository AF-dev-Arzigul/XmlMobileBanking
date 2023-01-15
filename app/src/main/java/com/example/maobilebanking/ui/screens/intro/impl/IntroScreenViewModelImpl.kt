package com.example.maobilebanking.ui.screens.intro.impl

import androidx.lifecycle.ViewModel
import com.example.maobilebanking.di.NavigationHelper
import com.example.maobilebanking.model.repository.AuthRepository
import com.example.maobilebanking.ui.screens.intro.IntroScreenDirections
import com.example.maobilebanking.ui.screens.intro.IntroScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroScreenViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private val navigationHelper: NavigationHelper
) :ViewModel(), IntroScreenViewModel{
    override suspend fun accept() {
        authRepository.disableFirstLaunch()
        navigationHelper.navigateTo(IntroScreenDirections.actionIntroScreenToLoginScreen())
    }
}