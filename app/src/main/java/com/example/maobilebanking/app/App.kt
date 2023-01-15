package com.example.maobilebanking.app

import android.app.Application
import com.example.maobilebanking.model.local.sharedpref.MySharedPref
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
//        MySharedPref.init(this)
    }
}

