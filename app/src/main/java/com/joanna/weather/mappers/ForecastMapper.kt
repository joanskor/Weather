package com.joanna.weather.mappers

import com.joanna.weather.api.responses.DailyForecast
import com.joanna.weather.models.Forecast

/**
 * Created by Joanna on 17.05.2021
 */
fun DailyForecast.toForecast(): Forecast {
    val unit = temperature?.minimum?.unit
    val minTemperature = temperature?.minimum?.value ?: 0.0f
    val maxTemperature = temperature?.maximum?.value ?: 0.0f
    val celsiusMin =
        if (unit.equals("C")) minTemperature else convertFahrenheitToCelsius(minTemperature)
    val celsiusMax =
        if (unit.equals("C")) maxTemperature else convertFahrenheitToCelsius(maxTemperature)

    return Forecast(
        date = endEpochDate ?: 0L,
        minTemperature = celsiusMin,
        maxTemperature = celsiusMax,
        unit = "°C",
        icon = day?.icon ?: 1
    )
}

private fun convertFahrenheitToCelsius(fahrenheit: Float): Float = ((fahrenheit - 32) * 5) / 9f