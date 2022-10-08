package br.com.felippeneves.kotlin_base_project.data.model.response

import br.com.felippeneves.kotlin_base_project.domain.model.CategoryEnt

data class BaseCategoryResponse (
    val categories: List<CategoryResponse>
)

data class CategoryResponse(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

fun CategoryResponse.toCategory() = CategoryEnt(
    id = this.idCategory,
    name = this.strCategory,
    thumb = this.strCategoryThumb,
    description = this.strCategoryDescription
)