package com.ithirteeng.common.cart.domain.usecase

import com.ithirteeng.common.cart.domain.model.CartModel
import com.ithirteeng.common.cart.domain.repository.CartRepository

class DeleteDishFromCartUseCase(
    private val repository: CartRepository
) {
    operator fun invoke(cartModel: CartModel) {
        repository.deleteDishFromCart(cartModel)
    }
}