package com.ithirteeng.features.category.di

import com.ithirteeng.common.network.retrofitservice.createRetrofitService
import com.ithirteeng.features.category.data.api.DishesApi
import com.ithirteeng.features.category.data.repository.DishesRepositoryImpl
import com.ithirteeng.features.category.domain.repository.DishesRepository
import com.ithirteeng.features.category.domain.usecase.GetDishesListUseCase
import com.ithirteeng.features.category.domain.usecase.GetTagsListUseCase
import com.ithirteeng.features.category.presentation.DishDialogViewModel
import com.ithirteeng.features.category.presentation.DishesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val FRAGMENT_VIEW_MODEL = "FRAGMENT_VIEW_MODEL"
const val DIALOG_VIEW_MODEL = "DIALOG_VIEW_MODEL"

val dishesModule = module {
    single { createRetrofitService<DishesApi>(retrofit = get()) }

    factory<DishesRepository> { DishesRepositoryImpl(api = get()) }

    factory { GetDishesListUseCase(repository = get()) }
    factory { GetTagsListUseCase(repository = get()) }

    viewModel(named(FRAGMENT_VIEW_MODEL)) {
        DishesViewModel(
            router = get(),
            getDishesListUseCase = get(),
            getTagsListUseCase = get(),
        )
    }

    viewModel(named(DIALOG_VIEW_MODEL)) {
        DishDialogViewModel(
            addDishToCartUseCase = get()
        )
    }
}