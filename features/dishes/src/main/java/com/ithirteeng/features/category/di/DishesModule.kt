package com.ithirteeng.features.category.di

import com.ithirteeng.common.network.retrofitservice.createRetrofitService
import com.ithirteeng.features.category.data.api.DishesApi
import com.ithirteeng.features.category.data.repository.DishesRepositoryImpl
import com.ithirteeng.features.category.domain.repository.DishesRepository
import com.ithirteeng.features.category.domain.usecase.GetDishesListUseCase
import com.ithirteeng.features.category.domain.usecase.GetTagsListUseCase
import com.ithirteeng.features.category.presentation.DishesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dishesModule = module {
    single { createRetrofitService<DishesApi>(retrofit = get()) }

    factory<DishesRepository> { DishesRepositoryImpl(api = get()) }

    factory { GetDishesListUseCase(repository = get()) }
    factory { GetTagsListUseCase(repository = get()) }

    viewModel {
        DishesViewModel(
            router = get(),
            getDishesListUseCase = get(),
            getTagsListUseCase = get(),
            addDishToCartUseCase = get()
        )
    }
}