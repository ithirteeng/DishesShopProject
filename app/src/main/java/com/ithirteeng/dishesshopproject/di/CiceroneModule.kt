package com.ithirteeng.dishesshopproject.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.ithirteeng.common.extensions.GLOBAL_ROUTER
import com.ithirteeng.common.extensions.LOCAL_ROUTER
import com.ithirteeng.common.extensions.MAIN_HOST_ROUTER
import com.ithirteeng.dishesshopproject.navigation.createCicerone
import com.ithirteeng.dishesshopproject.navigation.routers.BottomNavigationRouter
import org.koin.core.qualifier.named
import org.koin.dsl.module

val ciceroneModule = module {
    single(named(GLOBAL_ROUTER)) { createCicerone() }
    single(named(GLOBAL_ROUTER)) { get<Cicerone<Router>>(named(GLOBAL_ROUTER)).router }
    single(named(GLOBAL_ROUTER)) { get<Cicerone<Router>>(named(GLOBAL_ROUTER)).getNavigatorHolder() }

    single(named(MAIN_HOST_ROUTER)) { createCicerone() }
    single(named(MAIN_HOST_ROUTER)) { get<Cicerone<Router>>(named(MAIN_HOST_ROUTER)).router }
    single(named(MAIN_HOST_ROUTER)) { get<Cicerone<Router>>(named(MAIN_HOST_ROUTER)).getNavigatorHolder() }

    single(named(LOCAL_ROUTER)) { createCicerone() }
    single(named(LOCAL_ROUTER)) { get<Cicerone<Router>>(named(LOCAL_ROUTER)).router }
    single(named(LOCAL_ROUTER)) { get<Cicerone<Router>>(named(LOCAL_ROUTER)).getNavigatorHolder() }

    single { BottomNavigationRouter(hostRouter = get(named(MAIN_HOST_ROUTER))) }
}