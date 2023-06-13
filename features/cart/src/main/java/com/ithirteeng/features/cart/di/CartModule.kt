package com.ithirteeng.features.cart.di

import com.ithirteeng.features.cart.presentation.CartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cartModule = module {
    viewModel {
        CartViewModel(
            getAllDishesFromCartUseCase = get(),
            changeDishQuantityUseCase = get(),
            deleteDishFromCartUseCase = get()
        )
    }
}