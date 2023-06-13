package com.ithirteeng.features.category.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ithirteeng.common.cart.domain.usecase.AddDishToCartUseCase
import com.ithirteeng.features.category.data.mapper.toCartModel
import com.ithirteeng.features.category.domain.model.DishesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DishDialogViewModel(
    private val addDishToCartUseCase: AddDishToCartUseCase,
) : ViewModel() {

    private val _completionLiveData = MutableLiveData(true)

    val completionLiveData: LiveData<Boolean> = _completionLiveData

    fun addDishToCart(dishesModel: DishesModel, onErrorAppearance: (java.lang.Exception) -> Unit) {
        try {
            _completionLiveData.value = false
            viewModelScope.launch(Dispatchers.IO) {
                addDishToCartUseCase(dishesModel.toCartModel())
                _completionLiveData.postValue(true)
            }
        } catch (e: Exception) {
            onErrorAppearance(e)
        }

    }
}