package com.ithirteeng.features.mainhost.presentation

import androidx.lifecycle.ViewModel

class MainHostViewModel(
    private val router: MainHostRouter,
) : ViewModel() {

    fun getCurrentSectionType() = router.getCurrentSection()

    fun navigateToMainScreen() =
        router.navigateToMainScreen()

    fun navigateToCartScreen() =
        router.navigateToCartScreen()

    fun clearBackstack() {
        router.clearBackstack()
    }

    fun exit() = router.exit()
}