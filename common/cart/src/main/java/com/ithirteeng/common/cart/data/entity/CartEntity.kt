package com.ithirteeng.common.cart.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class CartEntity(
    @PrimaryKey
    val dishId: String,
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    val imageUrl: String,
    val quantity: Int = 1,
)