package com.example.maobilebanking.ui.screens.auth.signin.accountrecovery.impl

import androidx.lifecycle.ViewModel
import com.example.maobilebanking.model.repository.AuthRepository
import com.example.maobilebanking.ui.screens.auth.signin.accountrecovery.AccountRecoveryScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountRecoveryScreenViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository
) : AccountRecoveryScreenViewModel, ViewModel(){


}