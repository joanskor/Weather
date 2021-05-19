package com.joanna.weather.viewModels.weatherDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joanna.weather.R
import com.joanna.weather.common.ResourceProvider
import com.joanna.weather.mappers.toForecast
import com.joanna.weather.models.Weather
import com.joanna.weather.navigation.MainFlow
import com.joanna.weather.repositories.WeatherRepository
import com.joanna.weather.viewModels.BaseViewModel

/**
 * Created by Joanna on 13.05.2021
 */
class WeatherDetailsViewModel(
    weather: Weather,
    private val resourceProvider: ResourceProvider,
    private val weatherRepository: WeatherRepository,
    private val mainFlow: MainFlow
) : BaseViewModel() {
    val date: LiveData<String> = MutableLiveData(weather.date)
    val cityName: LiveData<String> = MutableLiveData(weather.city.name)
    val temperature: LiveData<Float> = MutableLiveData(weather.temperature)
    val unit: LiveData<String> = MutableLiveData(weather.unit)
    val icon: LiveData<Int> = MutableLiveData(weather.icon)
    private val _forecastList = MutableLiveData<List<ForecastRowViewModel>>(emptyList())
    var forecastList: LiveData<List<ForecastRowViewModel>> = _forecastList

    init {
        weatherRepository.getForecastByLocationKey(weather.city.key)
            .map { dailyForecasts -> dailyForecasts.dailyForecasts?.map { it.toForecast() } }
            .map { it?.map { forecast -> ForecastRowViewModel(forecast) } }
            .subscribeWithDispose(
                onSuccess = { _forecastList.postValue(it) },
                onError = { setError(resourceProvider.getString(R.string.getting_forecast_error)) }
            )
    }

    fun onBack() = mainFlow.navigateBack()
}