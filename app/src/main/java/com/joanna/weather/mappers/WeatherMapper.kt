package com.joanna.weather.mappers

import com.joanna.weather.api.responses.WeatherResponse
import com.joanna.weather.models.City
import com.joanna.weather.models.Weather
import com.joanna.weather.parseEpochToStringDate

/**
 * Created by Joanna on 17.05.2021
 */
fun WeatherResponse.toWeather(city: City): Weather = Weather(
    date = epochTime?.parseEpochToStringDate() ?: "",
    temperature = temperature?.metric?.value ?: 0.0f,
    unit = if (temperature?.metric?.unit.equals("C")) "°C" else temperature?.metric?.unit!!,
    icon = weatherIcon ?: 1,
    city = city
)