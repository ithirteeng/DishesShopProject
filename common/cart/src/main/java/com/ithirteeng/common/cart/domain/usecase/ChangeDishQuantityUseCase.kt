package com.ithirteeng.common.cart.domain.usecase

import com.ithirteeng.common.cart.domain.repository.CartRepository

class ChangeDishQuantityUseCase(
    private val repository: CartRepository
) {
    operator fun invoke(dishId: String, newQuantity: Int) {
        repository.changeQuantity(dishId, newQuantity)
    }
}