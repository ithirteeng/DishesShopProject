package com.ithirteeng.common.cart.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ithirteeng.common.cart.data.entity.CartEntity
import retrofit2.http.DELETE

@Dao
interface CartDao {
    @Insert
    fun addDishToCart(cartEntity: CartEntity)

    @Query(
        "UPDATE cart_table " +
                "SET quantity = :newQuantity " +
                "WHERE dishId = :dishId"
    )
    fun changeQuantity(dishId: String, newQuantity: Int)

    @DELETE
    fun deleteDishFromCart(cartEntity: CartEntity)

    @Query("SELECT * FROM cart_table")
    fun getAllDishesFromCart(): List<CartEntity>?

    @Query("DELETE FROM cart_table")
    fun clearCart()


}