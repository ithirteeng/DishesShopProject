package com.ithirteeng.features.kitchens.data.api

import com.ithirteeng.features.kitchens.data.entity.CategoriesListEntity
import retrofit2.http.GET

interface KitchensApi {
    @GET("058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategories(): CategoriesListEntity
}