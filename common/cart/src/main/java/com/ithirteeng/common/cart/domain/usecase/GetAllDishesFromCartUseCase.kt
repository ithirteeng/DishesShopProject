package com.ithirteeng.common.cart.domain.usecase

import com.ithirteeng.common.cart.domain.model.CartModel
import com.ithirteeng.common.cart.domain.repository.CartRepository

class GetAllDishesFromCartUseCase(
    private val repository: CartRepository,
) {
    operator fun invoke(): List<CartModel>? {
        return repository.getAllDishesFromCart()
    }
}