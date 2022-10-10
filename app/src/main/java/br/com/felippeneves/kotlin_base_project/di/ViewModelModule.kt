package br.com.felippeneves.kotlin_base_project.di

import br.com.felippeneves.kotlin_base_project.presentation.viewmodel.MealViewModel
import br.com.felippeneves.kotlin_base_project.presentation.viewmodel.UserRegisterViewModel
import br.com.felippeneves.kotlin_base_project.presentation.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MealViewModel(get())
    }

    viewModel {
        UsersViewModel(get())
    }

    viewModel {
        UserRegisterViewModel(get())
    }
}
