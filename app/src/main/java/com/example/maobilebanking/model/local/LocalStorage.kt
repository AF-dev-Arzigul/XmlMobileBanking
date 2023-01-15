package com.example.maobilebanking.model.local

import android.content.Context
import com.example.maobilebanking.uitls.SharedPreferenceHelper
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalStorage @Inject constructor(
    @ApplicationContext context: Context
) : SharedPreferenceHelper(context) {

    var isFirstLaunch: Boolean by booleans(true)
    var isSignedIn: Boolean by booleans(true)
    var accessToken: String by strings()
    var refreshToken: String by strings()

}