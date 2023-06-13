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
                _billLiveData.postValue(countBill(list))
                _dishesListLiveData.postValue(list)
            }
            _completionLiveData.postValue(true)
        }
    }

    fun changeDishQuantity(cartModel: CartModel, quantity: Int) {
        _completionLiveData.value = false
        viewModelScope.launch(Dispatchers.IO) {
            changeDishQuantityUseCase(cartModel.dishId, quantity)
            _billLiveData.postValue(
                countBill(
                    oldQuantity = cartModel.quantity,
                    newQuantity = quantity,
                    price = cartModel.price,
                    oldBill = _billLiveData.value!!
                )
            )
            _completionLiveData.postValue(true)
        }
    }

    fun deleteDishFromCart(cartModel: CartModel, onErrorAppearance: () -> Unit) {
        _completionLiveData.value = false
        viewModelScope.launch(Dispatchers.IO) {
            deleteDishFromCartUseCase(cartModel)
            getModelsList(onErrorAppearance)
        }
    }

    private val _billLiveData = MutableLiveData(0)

    val billLiveData: LiveData<Int> = _billLiveData

    private fun countBill(oldQuantity: Int, newQuantity: Int, price: Int, oldBill: Int): Int {
        val result = 0 - oldQuantity * price + newQuantity * price
        return oldBill + result
    }

    private fun countBill(list: List<CartModel>): Int {
        var amount = 0
        for (dish in list) {
            amount += dish.quantity * dish.price
        }
        return amount
    }

}