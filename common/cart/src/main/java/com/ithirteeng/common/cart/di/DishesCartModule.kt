package com.ithirteeng.common.cart.di

import com.ithirteeng.common.cart.data.repository.CartRepositoryImpl
import com.ithirteeng.common.cart.data.storage.provideDatabase
import com.ithirteeng.common.cart.domain.repository.CartRepository
import com.ithirteeng.common.cart.domain.usecase.AddDishToCartUseCase
import com.ithirteeng.common.cart.domain.usecase.ChangeDishQuantityUseCase
import com.ithirteeng.common.cart.domain.usecase.ClearCartUseCase
import com.ithirteeng.common.cart.domain.usecase.DeleteDishFromCartUseCase
import com.ithirteeng.common.cart.domain.usecase.GetAllDishesFromCartUseCase
import org.koin.dsl.module

val dishesCartModule = module {
    single { provideDatabase(application = get()) }

    factory<CartRepository> { CartRepositoryImpl(database = get()) }

    factory { AddDishToCartUseCase(repository = get()) }
    factory { ClearCartUseCase(repository = get()) }
    factory { ChangeDishQuantityUseCase(repository = get()) }
    factory { DeleteDishFromCartUseCase(repository = get()) }
    factory { GetAllDishesFromCartUseCase(repository = get()) }
}