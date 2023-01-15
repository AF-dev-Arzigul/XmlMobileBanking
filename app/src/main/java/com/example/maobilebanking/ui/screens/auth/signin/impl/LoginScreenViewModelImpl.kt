package com.example.maobilebanking.ui.screens.auth.signin.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.maobilebanking.di.NavigationHelper
import com.example.maobilebanking.model.repository.AuthRepository
import com.example.maobilebanking.ui.screens.auth.signin.LoginScreenDirections
import com.example.maobilebanking.ui.screens.auth.signin.LoginScreenViewModel
import com.example.maobilebanking.uitls.ResultData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private val navigationHelper: NavigationHelper
) : LoginScreenViewModel, ViewModel() {
    override val loading = MutableStateFlow(false)
    override val error = MutableStateFlow(false)
    override fun login(phone: String, password: String) {
        loading.tryEmit(true)
        authRepository.login(phone, password)
            .onEach {
                loading.emit(false)
                when (it) {
                    is ResultData.Error -> {
                        Log.d("ZZZZ", "error")
                        error.emit(true)
                    }
                    is ResultData.Success -> {
                        Log.d("ZZZZ", "${it.data?.token}")
                        navigationHelper.navigateTo(
                            LoginScreenDirections.actionLoginScreenToSignInverifyScreen2(it.data!!.token)
                        )
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    override fun openSignUpScreen() {
        viewModelScope.launch {
            navigationHelper.navigateTo(LoginScreenDirections.actionLoginScreenToSignUpScreen())
        }
    }
}