package com.ithirteeng.features.category.data.repository

import com.ithirteeng.features.category.data.api.DishesApi
import com.ithirteeng.features.category.data.mapper.toModelsList
import com.ithirteeng.features.category.data.mapper.toTagsList
import com.ithirteeng.features.category.domain.model.DishesModel
import com.ithirteeng.features.category.domain.model.TagModel
import com.ithirteeng.features.category.domain.repository.DishesRepository

class DishesRepositoryImpl(
    private val api: DishesApi,
) : DishesRepository {

    override suspend fun getDishesList(): List<DishesModel> {
        return api.getDishes().dishes.toModelsList()
    }

    override fun getTagsList(list: List<DishesModel>): List<TagModel> {
        return list.toTagsList()
    }
}