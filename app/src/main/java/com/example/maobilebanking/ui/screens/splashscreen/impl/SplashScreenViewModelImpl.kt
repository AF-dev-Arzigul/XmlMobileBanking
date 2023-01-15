package com.example.maobilebanking.ui.screens.splashscreen.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maobilebanking.di.NavigationHelper
import com.example.maobilebanking.model.repository.AuthRepository
import com.example.maobilebanking.ui.screens.splashscreen.SplashScreenDirections
import com.example.maobilebanking.ui.screens.splashscreen.SplashScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private val navigationHelper: NavigationHelper
) : SplashScreenViewModel, ViewModel() {
    init {
        viewModelScope.launch {
            delay(1000)
            when {
                authRepository.isFirstLaunch() -> {
                    Log.d("ZZZZZ", "first launch")
                    navigationHelper.navigateTo(SplashScreenDirections.actionSplashScreenToIntroScreen())
                }
                authRepository.isSignedIn() -> {
                    Log.d("ZZZZZ", "signed in")
                    navigationHelper.navigateTo(SplashScreenDirections.actionSplashScreenToMainScreen2())
                }
//                authRepository.isNotSinged() -> {
//                    Log.d("ZZZZZ", "not signed")
//                }
                else -> {
                    navigationHelper.navigateTo(SplashScreenDirections.actionSplashScreenToLoginScreen())
//                    navigationHelper.navigateTo(SplashScreenDirections.actionSplashScreenToSignUpVerifyScreen())
                }
            }
        }
    }
}