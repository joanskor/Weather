package com.joanna.weather.di

import com.joanna.weather.repositories.CitiesRepository
import com.joanna.weather.repositories.CitiesRepositoryImpl
import com.joanna.weather.repositories.WeatherRepository
import com.joanna.weather.repositories.WeatherRepositoryImpl
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy

/**
 * Created by Joanna on 13.05.2021
 */
val repositoryModule = module {
    singleBy<CitiesRepository, CitiesRepositoryImpl>()
    singleBy<WeatherRepository, WeatherRepositoryImpl>()
}