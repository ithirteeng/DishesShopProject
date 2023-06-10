package com.ithirteeng.dishesshopproject.di

import com.ithirteeng.dishesshopproject.navigation.routers.MainHostRouterImpl
import com.ithirteeng.features.mainhost.presentation.MainHostRouter
import org.koin.dsl.module

val routersModule = module {
    factory<MainHostRouter> { MainHostRouterImpl(router = get()) }
}