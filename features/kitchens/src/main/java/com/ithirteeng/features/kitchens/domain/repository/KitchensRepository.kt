package com.ithirteeng.features.kitchens.domain.repository

import com.ithirteeng.features.kitchens.domain.model.CategoryModel

interface KitchensRepository {
    suspend fun getCategories(): List<CategoryModel>
}