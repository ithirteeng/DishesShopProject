package com.ithirteeng.features.mainhost.presentation

import com.ithirteeng.features.mainhost.utils.SectionType

interface MainHostRouter {

    fun navigateToMainScreen()

    fun navigateToCartScreen()

    fun exit()

    fun getCurrentSection(): SectionType?

    fun clearBackstack()
}