package com.example.maobilebanking.ui.screens.auth.signin.verify

import com.example.maobilebanking.model.remote.request.SignUpVerifyRequest
import kotlinx.coroutines.flow.StateFlow

interface SignUpVerifyScreenViewModel {
    val loading: StateFlow<Boolean>
    val message: StateFlow<String?>
    suspend fun check(signUpVerifyRequest: SignUpVerifyRequest)


}