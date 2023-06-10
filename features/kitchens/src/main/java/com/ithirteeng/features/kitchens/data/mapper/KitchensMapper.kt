package com.ithirteeng.features.kitchens.data.mapper

import com.ithirteeng.features.kitchens.data.entity.CategoryEntity
import com.ithirteeng.features.kitchens.domain.model.CategoryModel

private fun CategoryEntity.toModel(): CategoryModel =
    CategoryModel(
        id = this.id,
        name = this.name,
        imageUrl = this.imageUrl
    )

fun List<CategoryEntity>.toModelsList(): List<CategoryModel> =
    this.map { it.toModel() }
