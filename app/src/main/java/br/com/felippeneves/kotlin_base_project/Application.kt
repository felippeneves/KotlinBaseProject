package br.com.felippeneves.kotlin_base_project

import android.app.Application
import br.com.felippeneves.kotlin_base_project.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(listOf(databaseModule, apiModule, repositoryModule, useCaseModule, viewModelModule))
        }
    }
}