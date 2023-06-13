package com.ithirteeng.features.kitchens.di

import com.ithirteeng.common.network.retrofitservice.createRetrofitService
import com.ithirteeng.features.kitchens.data.api.KitchensApi
import com.ithirteeng.features.kitchens.data.repository.KitchensRepositoryImpl
import com.ithirteeng.features.kitchens.domain.repository.KitchensRepository
import com.ithirteeng.features.kitchens.domain.usecase.GetCategoriesUseCase
import com.ithirteeng.features.kitchens.presentation.KitchensViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val kitchensModule = module {
    single { createRetrofitService<KitchensApi>(retrofit = get()) }

    factory<KitchensRepository> { KitchensRepositoryImpl(api = get()) }

    factory { GetCategoriesUseCase(repository = get()) }

    viewModel {
        KitchensViewModel(
            router = get(),
            getCategoriesUseCase = get()
        )
    }

}