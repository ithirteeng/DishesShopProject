package com.ithirteeng.dishesshopproject.navigation.routers

import com.github.terrakok.cicerone.Router
import com.ithirteeng.features.kitchens.ui.KitchensFragment
import com.ithirteeng.features.main.presentation.MainRouter

class MainRouterImpl(
    private val router: Router
): MainRouter {
    override fun navigateToKitchensScreen() {
        router.newRootScreen(KitchensFragment.provideScreen())
    }
}