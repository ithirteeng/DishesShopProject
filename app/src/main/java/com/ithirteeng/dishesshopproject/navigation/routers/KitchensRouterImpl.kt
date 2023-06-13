package com.ithirteeng.dishesshopproject.navigation.routers

import com.github.terrakok.cicerone.Router
import com.ithirteeng.features.category.ui.DishesFragment
import com.ithirteeng.features.kitchens.presentation.KitchensRouter

class KitchensRouterImpl(
    private val router: Router
): KitchensRouter {
    override fun navigateToDishesScreen(categoryName: String) {
        router.navigateTo(DishesFragment.provideScreen(categoryName))
    }
}