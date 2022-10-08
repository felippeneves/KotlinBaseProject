package br.com.felippeneves.kotlin_base_project.di

import br.com.felippeneves.kotlin_base_project.data.repository.database.AppDatabase
import br.com.felippeneves.kotlin_base_project.data.repository.database.dao.UserDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        AppDatabase.getDbInstance(androidContext())
    }

    single {
        get<AppDatabase>().userDao()
    }
}
