package com.ithirteeng.features.category.data.api

import com.ithirteeng.features.category.data.entity.DishesListEntity
import retrofit2.http.GET

interface DishesApi {
    @GET("aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getDishes(): DishesListEntity
}