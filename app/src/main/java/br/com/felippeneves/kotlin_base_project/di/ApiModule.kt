package br.com.felippeneves.kotlin_base_project.di

import br.com.felippeneves.kotlin_base_project.data.repository.api.MealApi
import br.com.felippeneves.kotlin_base_project.data.repository.api.RetrofitJsonInstance
import org.koin.dsl.module

val apiModule = module {
    single {
        RetrofitJsonInstance().createService(MealApi::class.java)
    }
}
