package br.com.felippeneves.kotlin_base_project.data.repository.api

import br.com.felippeneves.kotlin_base_project.data.model.response.BaseCategoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealApi {
    @GET("categories.php")
    suspend fun getCategories(): Response<BaseCategoryResponse>
}