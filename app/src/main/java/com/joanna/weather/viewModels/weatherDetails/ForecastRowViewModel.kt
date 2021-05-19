package com.joanna.weather.viewModels.weatherDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joanna.weather.models.Forecast
import com.joanna.weather.parseEpochToStringDate

/**
 * Created by Joanna on 17.05.2021
 */
class ForecastRowViewModel(val forecast: Forecast) {
    private val minTemperature = String.format("%.1f", forecast.minTemperature)
    private val maxTemperature = String.format("%.1f", forecast.maxTemperature)
    private val unit = forecast.unit
    val temperature: LiveData<String> =
        MutableLiveData("$minTemperature - $maxTemperature $unit")
    val icon: LiveData<Int> = MutableLiveData(forecast.icon)
    val date: LiveData<String> = MutableLiveData(forecast.date?.parseEpochToStringDate())
}