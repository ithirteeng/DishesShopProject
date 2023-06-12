package com.ithirteeng.common.cart.domain.repository

import com.ithirteeng.common.cart.domain.model.CartModel

interface CartRepository {

    fun addDishToCart(cartModel: CartModel)

    fun changeQuantity(dishId: String, newQuantity: Int)

    fun deleteDishFromCart(cartModel: CartModel)

    fun getAllDishesFromCart(): List<CartModel>?

    fun clearCart()
}