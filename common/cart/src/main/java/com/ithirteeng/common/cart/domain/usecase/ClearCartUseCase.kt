package com.ithirteeng.common.cart.domain.usecase

import com.ithirteeng.common.cart.domain.repository.CartRepository

class ClearCartUseCase(
    private val repository: CartRepository
) {
    operator fun invoke() {
        repository.clearCart()
    }
}