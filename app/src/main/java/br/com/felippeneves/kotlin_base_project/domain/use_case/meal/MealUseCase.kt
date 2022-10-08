package br.com.felippeneves.kotlin_base_project.domain.use_case.meal

import br.com.felippeneves.kotlin_base_project.domain.model.CategoryEnt

interface MealUseCase {
    suspend fun getCategories(): List<CategoryEnt>
}