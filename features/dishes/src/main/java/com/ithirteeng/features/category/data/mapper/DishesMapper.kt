package com.ithirteeng.features.category.data.mapper

import com.ithirteeng.common.cart.domain.model.CartModel
import com.ithirteeng.features.category.data.entity.DishesEntity
import com.ithirteeng.features.category.domain.model.DishesModel

private fun DishesEntity.toModel(): DishesModel {
    return DishesModel(
        id = this.id,
        name = this.name,
        price = this.price,
        weight = this.weight,
        description = this.description,
        imageUrl = this.imageUrl,
        tags = this.tags
    )
}

fun List<DishesEntity>.toModelsList(): List<DishesModel> {
    return this.map { it.toModel() }
}

fun List<DishesModel>.toTagsList(): List<String> {
    val result = arrayListOf<String>()
    for (model in this) {
        result += model.tags
    }
    return result.distinct()
}

fun DishesModel.toCartModel(): CartModel {
    return CartModel(
        dishId = this.id,
        name = this.name,
        price = this.price,
        weight = this.weight,
        description = this.description,
        imageUrl = this.imageUrl,
        quantity = 1
    )
}