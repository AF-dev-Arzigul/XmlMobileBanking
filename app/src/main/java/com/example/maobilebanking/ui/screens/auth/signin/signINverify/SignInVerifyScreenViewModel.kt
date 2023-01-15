package com.example.maobilebanking.ui.screens.auth.signin.signINverify

import com.example.maobilebanking.model.remote.request.SignInVerifyRequest
import kotlinx.coroutines.flow.StateFlow

interface SignInVerifyScreenViewModel {
    val loading: StateFlow<Boolean>
    val message: StateFlow<String?>
    suspend fun check(request: SignInVerifyRequest)


}