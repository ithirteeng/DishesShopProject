package com.ithirteeng.features.category.domain.model

data class DishesModel(
    val id: String,
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    val imageUrl: String,
    val tags: List<String>,
)