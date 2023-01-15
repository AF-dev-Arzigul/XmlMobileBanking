package com.example.maobilebanking.ui.screens.auth.signin

import kotlinx.coroutines.flow.StateFlow

interface LoginScreenViewModel {
    val loading:StateFlow<Boolean>
    val error:StateFlow<Boolean>
    fun login(phone: String, password: String)
    fun openSignUpScreen()
}