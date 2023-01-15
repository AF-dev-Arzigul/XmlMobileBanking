package com.example.maobilebanking.ui.screens.auth.signin.verify.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maobilebanking.di.NavigationHelper
import com.example.maobilebanking.model.local.LocalStorage
import com.example.maobilebanking.model.remote.request.SignUpVerifyRequest
import com.example.maobilebanking.model.repository.AuthRepository
import com.example.maobilebanking.ui.screens.auth.signin.verify.SignUpVerifyScreen
import com.example.maobilebanking.ui.screens.auth.signin.verify.SignUpVerifyScreenDirections
import com.example.maobilebanking.ui.screens.auth.signin.verify.SignUpVerifyScreenViewModel
import com.example.maobilebanking.uitls.ResultData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SignUpVerifyScreenViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private val navigationHelper: NavigationHelper,
    private val storage: LocalStorage
) : SignUpVerifyScreenViewModel,
    ViewModel() {
    override val loading = MutableStateFlow(false)
    override val message = MutableStateFlow<String?>(null)

    override suspend fun check(signUpVerifyRequest: SignUpVerifyRequest) {
        if (signUpVerifyRequest.code.length == 6) {
            authRepository.verifySignUp(signUpVerifyRequest).onEach {
                when (it) {
                    is ResultData.Error -> {
                        message.emit("Code is wrong")
                    }
                    is ResultData.Success -> {
                        storage.isSignedIn = true
                        storage.accessToken = it.data.accessToken
                        storage.refreshToken = it.data.refreshToken
                        Log.d("ZZZZ", "${it.data.accessToken}")
                        Log.d("ZZZZ", "${it.data.refreshToken}")
                        navigationHelper.navigateTo(SignUpVerifyScreenDirections.actionSignUpVerifyScreenToMainScreen2())
                    }
                }
            }.launchIn(viewModelScope)
        } else {
            message.emit("Code is wrong")
        }
    }
}