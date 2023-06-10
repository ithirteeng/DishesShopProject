package com.ithirteeng.features.kitchens.domain.usecase

import com.ithirteeng.common.extensions.provideResult
import com.ithirteeng.features.kitchens.domain.model.CategoryModel
import com.ithirteeng.features.kitchens.domain.repository.KitchensRepository

class GetCategoriesUseCase(
    private val repository: KitchensRepository,
) {
    suspend operator fun invoke(): Result<List<CategoryModel>> {
        return provideResult {
            repository.getCategories()
        }
    }
}