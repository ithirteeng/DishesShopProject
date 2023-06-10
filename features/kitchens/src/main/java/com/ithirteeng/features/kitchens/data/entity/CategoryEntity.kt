package com.ithirteeng.features.kitchens.data.entity

import com.google.gson.annotations.SerializedName

data class CategoryEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("image_url")
    val imageUrl: String,
)
