package com.ithirteeng.features.category.di

import com.ithirteeng.common.network.retrofitservice.createRetrofitService
import com.ithirteeng.features.category.data.api.DishesApi
import com.ithirteeng.features.category.data.repository.DishesRepositoryImpl
import com.ithirteeng.features.category.domain.repository.DishesRepository
import com.ithirteeng.features.category.domain.usecase.GetDishesListUseCase
import com.ithirteeng.features.category.domain.usecase.GetTagsListUseCase
import org.koin.dsl.module

val dishesModule = module {
    single { createRetrofitService<DishesApi>(retrofit = get()) }

    factory<DishesRepository> { DishesRepositoryImpl(api = get()) }

    factory { GetDishesListUseCase(repository = get()) }
    factory { GetTagsListUseCase(repository = get()) }
}