package com.ithirteeng.features.category.domain.repository

import com.ithirteeng.features.category.domain.model.DishesModel
import com.ithirteeng.features.category.domain.model.TagModel

interface DishesRepository {
    suspend fun getDishesList(): List<DishesModel>

    fun getTagsList(list: List<DishesModel>): List<TagModel>
}