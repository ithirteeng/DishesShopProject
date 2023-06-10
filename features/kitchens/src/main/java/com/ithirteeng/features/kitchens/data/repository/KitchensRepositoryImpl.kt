package com.ithirteeng.features.kitchens.data.repository

import com.ithirteeng.features.kitchens.data.api.KitchensApi
import com.ithirteeng.features.kitchens.data.mapper.toModelsList
import com.ithirteeng.features.kitchens.domain.model.CategoryModel
import com.ithirteeng.features.kitchens.domain.repository.KitchensRepository

class KitchensRepositoryImpl(
    private val api: KitchensApi,
) : KitchensRepository {
    override suspend fun getCategories(): List<CategoryModel> {
        return api.getCategories().categories.toModelsList()
    }
}