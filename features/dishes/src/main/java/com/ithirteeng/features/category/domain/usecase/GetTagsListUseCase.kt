package com.ithirteeng.features.category.domain.usecase

import com.ithirteeng.features.category.domain.model.DishesModel
import com.ithirteeng.features.category.domain.model.TagModel
import com.ithirteeng.features.category.domain.repository.DishesRepository

class GetTagsListUseCase(
    private val repository: DishesRepository,
) {
    operator fun invoke(list: List<DishesModel>): List<TagModel> {
        return repository.getTagsList(list)
    }
}