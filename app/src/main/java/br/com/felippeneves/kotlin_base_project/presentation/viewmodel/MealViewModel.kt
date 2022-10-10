package br.com.felippeneves.kotlin_base_project.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.felippeneves.kotlin_base_project.domain.model.CategoryEnt
import br.com.felippeneves.kotlin_base_project.domain.use_case.meal.MealUseCase
import kotlinx.coroutines.launch

class MealViewModel(
    private val mealUseCase: MealUseCase
) : ViewModel() {

    private val _categories = MutableLiveData<List<CategoryEnt>>()
    val categories: LiveData<List<CategoryEnt>> = _categories

    fun getCategories() {
        viewModelScope.launch {
            val listCategory = mealUseCase.getCategories()
            _categories.value = listCategory
        }
    }
}