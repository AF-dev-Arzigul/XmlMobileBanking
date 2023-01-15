package com.example.maobilebanking.di

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationHelper @Inject constructor(){
    val navigationBuffer = MutableSharedFlow<NavController.() -> Unit>()

    private suspend fun navigate(arg: NavController.() -> Unit) {
        navigationBuffer.emit(arg)
    }

    suspend fun navigateTo(direction: NavDirections) = navigate {
        navigate(direction)
    }

    suspend fun back() = navigate {
        navigateUp()
    }
}

