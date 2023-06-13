package com.ithirteeng.common.cart.domain.model

data class CartModel(
    val dishId: String,
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    val imageUrl: String,
    var quantity: Int,
)
