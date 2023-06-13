package com.ithirteeng.features.category.data.entity

import com.google.gson.annotations.SerializedName

data class DishesEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("tegs")
    val tags: List<String>,
)
