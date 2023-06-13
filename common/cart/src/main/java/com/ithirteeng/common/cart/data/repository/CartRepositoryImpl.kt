package com.ithirteeng.common.cart.data.repository

import com.ithirteeng.common.cart.data.mapper.toEntity
import com.ithirteeng.common.cart.data.mapper.toModelsList
import com.ithirteeng.common.cart.data.storage.CartDatabase
import com.ithirteeng.common.cart.domain.model.CartModel
import com.ithirteeng.common.cart.domain.repository.CartRepository

class CartRepositoryImpl(
    private val database: CartDatabase,
) : CartRepository {

    override fun addDishToCart(cartModel: CartModel) {
        database.getCartDao().addDishToCart(cartModel.toEntity())
    }

    override fun changeQuantity(dishId: String, newQuantity: Int) {
        database.getCartDao().changeQuantity(dishId, newQuantity)
    }

    override fun deleteDishFromCart(cartModel: CartModel) {
        database.getCartDao().deleteDishFromCart(cartModel.toEntity())
    }

    override fun getAllDishesFromCart(): List<CartModel>? {
        return database.getCartDao().getAllDishesFromCart()?.toModelsList()
    }

    override fun clearCart() {
        database.getCartDao().clearCart()
    }
}