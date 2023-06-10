package com.ithirteeng.features.kitchens.data.entity

import com.google.gson.annotations.SerializedName

class CategoriesListEntity(
    @SerializedName("сategories")
    val categories: List<CategoryEntity>,
)