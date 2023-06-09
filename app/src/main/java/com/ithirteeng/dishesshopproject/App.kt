package com.ithirteeng.dishesshopproject

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level
import org.koin.dsl.koinApplication

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        koinApplication {
            androidLogger(Level.ERROR)
            androidContext(this@App)

            modules(
            )
        }
    }
}