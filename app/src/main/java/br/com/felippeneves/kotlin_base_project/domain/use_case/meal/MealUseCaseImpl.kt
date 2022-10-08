package br.com.felippeneves.kotlin_base_project.domain.use_case.meal

import br.com.felippeneves.kotlin_base_project.domain.model.CategoryEnt
import br.com.felippeneves.kotlin_base_project.domain.repository.MealRepository

class MealUseCaseImpl(
    private val repository: MealRepository
) : MealUseCase {

    override suspend fun getCategories(): List<CategoryEnt> {
        return repository.getCategories()
    }
}