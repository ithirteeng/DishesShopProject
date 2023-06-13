package com.ithirteeng.features.category.domain.usecase

import com.ithirteeng.common.extensions.provideResult
import com.ithirteeng.features.category.domain.model.DishesModel
import com.ithirteeng.features.category.domain.repository.DishesRepository

class GetDishesListUseCase(
    private val repository: DishesRepository,
) {
    suspend operator fun invoke(): Result<List<DishesModel>> {
        return provideResult {
            repository.getDishesList()
        }
    }
}