package com.ithirteeng.features.kitchens.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ithirteeng.features.kitchens.domain.model.CategoryModel
import com.ithirteeng.features.kitchens.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.launch

class KitchensViewModel(
    private val router: KitchensRouter,
    private val getCategoriesUseCase: GetCategoriesUseCase,
) : ViewModel() {

    fun navigateToDishesScreen() {
        router.navigateToDishesScreen()
    }

    private val _categoriesLiveData = MutableLiveData<List<CategoryModel>>()

    val categoriesLiveData: LiveData<List<CategoryModel>> = _categoriesLiveData

    fun getCategories(onErrorAppearance: (it: Throwable) -> Unit) {
        viewModelScope.launch {
            getCategoriesUseCase()
                .onSuccess {
                    _categoriesLiveData.value = it
                }
                .onFailure {
                    onErrorAppearance(it)
                }
        }
    }
}