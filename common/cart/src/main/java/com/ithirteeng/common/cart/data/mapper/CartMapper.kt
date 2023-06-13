package com.ithirteeng.common.cart.data.mapper

import com.ithirteeng.common.cart.data.entity.CartEntity
import com.ithirteeng.common.cart.domain.model.CartModel

fun CartModel.toEntity(): CartEntity {
    return CartEntity(
        dishId = this.dishId,
        name = this.name,
        price = this.price,
        weight = this.weight,
        description = this.description,
        imageUrl = this.imageUrl,
        quantity = this.quantity
    )
}

fun CartEntity.toModel(): CartModel {
    return CartModel(
        dishId = this.dishId,
        name = this.name,
        price = this.price,
        weight = this.weight,
        description = this.description,
        imageUrl = this.imageUrl,
        quantity = this.quantity
    )
}

fun List<CartEntity>.toModelsList(): List<CartModel> {
    return this.map { it.toModel() }
}