package com.ithirteeng.features.category.domain.usecase

import com.ithirteeng.features.category.domain.model.DishesModel
import com.ithirteeng.features.category.domain.repository.DishesRepository

class GetTagsListUseCase(
    private val repository: DishesRepository,
) {
    operator fun invoke(list: List<DishesModel>): List<String> {
        return repository.getTagsList(list)
    }
}