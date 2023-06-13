package com.ithirteeng.features.category.data.entity

import com.google.gson.annotations.SerializedName

data class DishesListEntity(
    @SerializedName("dishes")
    val dishes: List<DishesEntity>,
)