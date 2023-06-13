package com.ithirteeng.dishesshopproject.di

import com.ithirteeng.dishesshopproject.network.okhttp.setupOkHttpClient
import com.ithirteeng.dishesshopproject.network.provideLoggingInterceptor
import com.ithirteeng.dishesshopproject.network.provideNetworkConnectionInterceptor
import com.ithirteeng.dishesshopproject.network.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    factory { provideLoggingInterceptor() }
    factory { provideNetworkConnectionInterceptor(context = get()) }

    single { provideRetrofit(okHttpClient = get()) }

    single {
        setupOkHttpClient(
            loggingInterceptor = get(),
            networkConnectionInterceptor = get()
        )
    }

}