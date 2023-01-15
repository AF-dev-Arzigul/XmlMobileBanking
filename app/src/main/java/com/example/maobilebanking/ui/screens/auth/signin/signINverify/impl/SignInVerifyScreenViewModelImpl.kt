package com.example.maobilebanking.ui.screens.auth.signin.signINverify.impl


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maobilebanking.di.NavigationHelper
import com.example.maobilebanking.model.local.LocalStorage
import com.example.maobilebanking.model.remote.request.SignInVerifyRequest
import com.example.maobilebanking.model.repository.AuthRepository
import com.example.maobilebanking.ui.screens.auth.signin.signINverify.SignInVerifyScreenDirections
import com.example.maobilebanking.ui.screens.auth.signin.signINverify.SignInVerifyScreenViewModel
import com.example.maobilebanking.uitls.ResultData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SignInVerifyScreenViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private val navigationHelper: NavigationHelper,
    private val storage: LocalStorage
) : SignInVerifyScreenViewModel,
    ViewModel() {
    override val loading = MutableStateFlow(false)
    override val message = MutableStateFlow<String?>(null)

    override suspend fun check(request: SignInVerifyRequest) {
        if (request.code.length == 6) {
            authRepository.verifySignIn(request).onEach {
                when (it) {
                    is ResultData.Error -> {
                        message.emit("Check again")
                    }
                    is ResultData.Success -> {
                        storage.isSignedIn = true
                        storage.accessToken = it.data.accessToken
                        storage.refreshToken = it.data.refreshToken
                        Log.d("ZZZZ", "${it.data.accessToken}")
                        Log.d("ZZZZ", "${it.data.refreshToken}")
                        navigationHelper.navigateTo(SignInVerifyScreenDirections.actionSignInverifyScreenToMainScreen2())
                    }
                }
            }.launchIn(viewModelScope)
        } else {
            message.emit("Check the code")
        }
    }

}