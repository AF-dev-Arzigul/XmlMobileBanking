package com.example.maobilebanking.ui.screens.auth.signup.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maobilebanking.di.NavigationHelper
import com.example.maobilebanking.model.remote.request.SignUpRequest
import com.example.maobilebanking.model.repository.AuthRepository
import com.example.maobilebanking.ui.screens.auth.signup.SignUpScreenDirections
import com.example.maobilebanking.ui.screens.auth.signup.SignUpScreenViewModel
import com.example.maobilebanking.ui.screens.splashscreen.SplashScreenDirections
import com.example.maobilebanking.uitls.ResultData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SignUpScreenViewModelImpl @Inject constructor(
    private val  authRepository: AuthRepository,
    private val navigationHelper: NavigationHelper
): SignUpScreenViewModel, ViewModel(){
    override val loading= MutableStateFlow<Boolean>(false)
    override val message= MutableStateFlow<String?>(null)

    override fun register(
        firstname: String,
        lastname: String,
        dateOfBirth: String,
        phone: String,
        password: String,
        gender: String
    ) {

        loading.tryEmit(true)
        val request = SignUpRequest(firstname, lastname, dateOfBirth, gender, phone, password)
        authRepository.register(request)
            .onEach {
                loading.emit(false)
                when (it) {
                    is ResultData.Success -> {
                        val token :String= it.data!!.token
                        navigationHelper.navigateTo(SignUpScreenDirections.actionSignUpScreenToSignUpVerifyScreen(token))
                    }
                    is ResultData.Error -> {
                        message.emit(it.message)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

}