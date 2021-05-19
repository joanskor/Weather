package com.joanna.weather.repositories

import com.joanna.weather.api.APIKEY
import com.joanna.weather.api.ForecastApi
import com.joanna.weather.api.makeRequest
import com.joanna.weather.api.responses.ForecastResponse
import com.joanna.weather.api.responses.WeatherResponse
import com.joanna.weather.common.ConnectivityService
import com.joanna.weather.common.SchedulerProvider
import io.reactivex.rxjava3.core.Single

/**
 * Created by Joanna on 17.05.2021
 */
interface WeatherRepository {
    fun getWeatherByLocationKey(locationKey: String): Single<List<WeatherResponse>>
    fun getForecastByLocationKey(locationKey: String): Single<ForecastResponse>
}

class WeatherRepositoryImpl(
    private val forecastApi: ForecastApi,
    private val schedulerProvider: SchedulerProvider,
    private val connectivityService: ConnectivityService
) : WeatherRepository {

    override fun getWeatherByLocationKey(locationKey: String): Single<List<WeatherResponse>> {
        return forecastApi.getWeatherByLocationKey(locationKey, APIKEY)
            .makeRequest(schedulerProvider, connectivityService)
            .onErrorReturn { emptyList() }
    }

    override fun getForecastByLocationKey(locationKey: String): Single<ForecastResponse> {
        return forecastApi.getForecastByLocationKey(locationKey, APIKEY)
            .makeRequest(schedulerProvider, connectivityService)
            .onErrorReturn { null }
    }
}