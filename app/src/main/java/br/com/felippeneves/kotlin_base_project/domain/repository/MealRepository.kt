package br.com.felippeneves.kotlin_base_project.domain.repository

import br.com.felippeneves.kotlin_base_project.domain.model.CategoryEnt

interface MealRepository {
    suspend fun getCategories(): List<CategoryEnt>
}