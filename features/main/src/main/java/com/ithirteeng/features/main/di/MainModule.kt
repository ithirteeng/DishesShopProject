package com.ithirteeng.features.main.di

import com.ithirteeng.features.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel {
        MainViewModel(
            router = get()
        )
    }
}