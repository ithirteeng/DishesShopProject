package com.ithirteeng.common.cart.domain.usecase

import com.ithirteeng.common.cart.domain.model.CartModel
import com.ithirteeng.common.cart.domain.repository.CartRepository

class AddDishToCartUseCase(
    private val repository: CartRepository,
) {
    operator fun invoke(cartModel: CartModel) {
        repository.addDishToCart(cartModel)
    }
}