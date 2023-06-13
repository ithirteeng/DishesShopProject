package com.ithirteeng.dishesshopproject

import android.app.Application
import com.ithirteeng.common.cart.di.dishesCartModule
import com.ithirteeng.dishesshopproject.di.ciceroneModule
import com.ithirteeng.dishesshopproject.di.networkModule
import com.ithirteeng.dishesshopproject.di.routersModule
import com.ithirteeng.features.category.di.dishesModule
import com.ithirteeng.features.kitchens.di.kitchensModule
import com.ithirteeng.features.main.di.mainModule
import com.ithirteeng.features.mainhost.di.mainHostModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)

            modules(
                networkModule,
                ciceroneModule,
                routersModule,
                mainHostModule,
                mainModule,
                kitchensModule,
                dishesCartModule,
                dishesModule
            )
        }
    }
}