package com.ithirteeng.dishesshopproject.navigation.routers

import com.github.terrakok.cicerone.Router
import com.ithirteeng.features.category.presentation.DishesRouter

class DishesRouterImpl(
    private val router: Router
): DishesRouter {
    override fun exit() {
        router.exit()
    }
}