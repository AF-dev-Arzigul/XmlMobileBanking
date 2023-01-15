package com.example.maobilebanking.ui.screens.auth.signup

import kotlinx.coroutines.flow.StateFlow

interface SignUpScreenViewModel {
    val loading: StateFlow<Boolean>
    val message: StateFlow<String?>
    fun register(firstname: String, lastname: String, dateOfBirth: String, phone: String, password: String, gender: String)
}