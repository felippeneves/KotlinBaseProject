package br.com.felippeneves.kotlin_base_project.di

import br.com.felippeneves.kotlin_base_project.domain.use_case.meal.MealUseCase
import br.com.felippeneves.kotlin_base_project.domain.use_case.meal.MealUseCaseImpl
import br.com.felippeneves.kotlin_base_project.domain.use_case.user.UserUseCase
import br.com.felippeneves.kotlin_base_project.domain.use_case.user.UserUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<MealUseCase> {
        MealUseCaseImpl(get())
    }

    single<UserUseCase> {
        UserUseCaseImpl(get())
    }
}
