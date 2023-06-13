package com.ithirteeng.features.cart.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ithirteeng.common.cart.domain.model.CartModel
import com.ithirteeng.common.cart.domain.usecase.ChangeDishQuantityUseCase
import com.ithirteeng.common.cart.domain.usecase.DeleteDishFromCartUseCase
import com.ithirteeng.common.cart.domain.usecase.GetAllDishesFromCartUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(
    private val changeDishQuantityUseCase: ChangeDishQuantityUseCase,
    private val deleteDishFromCartUseCase: DeleteDishFromCartUseCase,
    private val getAllDishesFromCartUseCase: GetAllDishesFromCartUseCase,
) : ViewModel() {

    private val _completionLiveData = MutableLiveData(true)

    val completionLiveData: LiveData<Boolean> = _completionLiveData

    private val _dishesListLiveData = MutableLiveData<List<CartModel>>()

    val dishesListLiveData: LiveData<List<CartModel>> = _dishesListLiveData

    fun getModelsList(onErrorAppearance: () -> Unit) {
        _completionLiveData.postValue(false)
        viewModelScope.launch(Dispatchers.IO) {
            val list = getAllDishesFromCartUseCase()
            if (list == null) {
                onErrorAppearance()
            } else {
                _dishesListLiveData.postValue(list!!)
            }
            _completionLiveData.postValue(true)
        }
    }

    fun changeDishQuantity(cartModel: CartModel, quantity: Int, onErrorAppearance: () -> Unit) {
        _completionLiveData.value = false
        viewModelScope.launch(Dispatchers.IO) {
            changeDishQuantityUseCase(cartModel.dishId, quantity)
            getModelsList(onErrorAppearance)
        }
    }

    fun deleteDishFromCart(cartModel: CartModel, onErrorAppearance: () -> Unit) {
        _completionLiveData.value = false
        viewModelScope.launch(Dispatchers.IO) {
            deleteDishFromCartUseCase(cartModel)
            getModelsList(onErrorAppearance)
        }
    }


}