package com.joanna.weather.di

import com.joanna.weather.models.Weather
import com.joanna.weather.viewModels.chooseCity.ChooseCityViewModel
import com.joanna.weather.viewModels.weatherDetails.WeatherDetailsViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Joanna on 13.05.2021
 */
val viewModelModule = module {
    viewModel<ChooseCityViewModel>()
    viewModel { (weather: Weather) ->
        WeatherDetailsViewModel(
            weather = weather,
            mainFlow = get(),
            weatherRepository = get(),
            resourceProvider = get()
        )
    }
}