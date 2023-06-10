package com.ithirteeng.features.main.presentation

import androidx.lifecycle.ViewModel

class MainViewModel(
    private val router: MainRouter,
) : ViewModel() {
    fun navigateToKitchensScreen() {
        router.navigateToKitchensScreen()
    }
}