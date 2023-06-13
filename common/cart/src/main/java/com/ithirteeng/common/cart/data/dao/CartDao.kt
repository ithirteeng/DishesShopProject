package com.ithirteeng.common.cart.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.ithirteeng.common.cart.data.entity.CartEntity

@Dao
interface CartDao {
    @Upsert
    fun addDishToCart(cartEntity: CartEntity)

    @Query(
        "UPDATE cart_table " +
                "SET quantity = :newQuantity " +
                "WHERE dishId = :dishId"
    )
    fun changeQuantity(dishId: String, newQuantity: Int)

    @Delete
    fun deleteDishFromCart(cartEntity: CartEntity)

    @Query("SELECT * FROM cart_table")
    fun getAllDishesFromCart(): List<CartEntity>?

    @Query("DELETE FROM cart_table")
    fun clearCart()


}