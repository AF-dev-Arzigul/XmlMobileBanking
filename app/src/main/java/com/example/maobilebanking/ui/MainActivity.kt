package com.example.maobilebanking.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.maobilebanking.R
import com.example.maobilebanking.databinding.ActivityMainBinding
import com.example.maobilebanking.di.NavigationHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigationHelper: NavigationHelper
    private val viewBinding by lazy(LazyThreadSafetyMode.NONE) { ActivityMainBinding.inflate(layoutInflater) }
    private val navController by lazy(LazyThreadSafetyMode.NONE) { viewBinding.navHostFragment.findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        navigationHelper.navigationBuffer
            .onEach { it(navController) }
            .launchIn(lifecycleScope)
    }
}