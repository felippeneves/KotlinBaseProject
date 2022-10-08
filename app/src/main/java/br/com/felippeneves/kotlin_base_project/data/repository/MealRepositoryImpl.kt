package br.com.felippeneves.kotlin_base_project.data.repository

import br.com.felippeneves.kotlin_base_project.data.model.response.toCategory
import br.com.felippeneves.kotlin_base_project.data.repository.api.MealApi
import br.com.felippeneves.kotlin_base_project.domain.model.CategoryEnt
import br.com.felippeneves.kotlin_base_project.domain.repository.MealRepository

class MealRepositoryImpl(
    private val api: MealApi
) : MealRepository {

    override suspend fun getCategories(): List<CategoryEnt> {
        return api.getCategories().body()?.categories?.map { it.toCategory() }!!
    }
}