package com.joanna.weather

import android.app.Application
import com.joanna.weather.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Joanna on 13.05.2021
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val modules =
            listOf(
                commonModule,
                navigationModule,
                networkModule,
                viewModelModule,
                repositoryModule
            )

        startKoin {
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}