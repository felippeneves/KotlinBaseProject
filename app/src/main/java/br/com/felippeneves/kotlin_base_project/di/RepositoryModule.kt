package br.com.felippeneves.kotlin_base_project.di

import br.com.felippeneves.kotlin_base_project.data.repository.MealRepositoryImpl
import br.com.felippeneves.kotlin_base_project.data.repository.UserRepositoryImpl
import br.com.felippeneves.kotlin_base_project.domain.repository.MealRepository
import br.com.felippeneves.kotlin_base_project.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MealRepository> {
        MealRepositoryImpl(get())
    }

    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}
