package com.ithirteeng.dishesshopproject.navigation.routers

import com.ithirteeng.features.bucket.CartFragment
import com.ithirteeng.features.main.MainFragment
import com.ithirteeng.features.mainhost.presentation.MainHostRouter
import com.ithirteeng.features.mainhost.utils.SectionType

class MainHostRouterImpl(
    private val router: BottomNavigationRouter,
) : MainHostRouter {
    override fun navigateToMainScreen() {
        router.openSection(MainFragment.provideScreen(), SectionType.MAIN)
    }

    override fun navigateToCartScreen() {
        router.openSection(CartFragment.provideScreen(), SectionType.CART)
    }

    override fun exit() {
        router.exit()
    }

    override fun getCurrentSection(): SectionType? {
        return router.getCurrentSectionType()
    }

    override fun clearBackstack() {
        router.clearBackStack()
    }

}