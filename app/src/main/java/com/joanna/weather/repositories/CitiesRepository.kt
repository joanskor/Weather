package com.joanna.weather.repositories

import com.joanna.weather.api.APIKEY
import com.joanna.weather.api.ForecastApi
import com.joanna.weather.api.makeRequest
import com.joanna.weather.common.ConnectivityService
import com.joanna.weather.common.SchedulerProvider
import com.joanna.weather.mappers.toCity
import com.joanna.weather.models.City
import io.reactivex.rxjava3.core.Single

/**
 * Created by Joanna on 13.05.2021
 */
interface CitiesRepository {
    fun getCitiesByAutocomplete(q: String): Single<List<City>>
}

class CitiesRepositoryImpl(
    private val forecastApi: ForecastApi,
    private val schedulerProvider: SchedulerProvider,
    private val connectivityService: ConnectivityService
) : CitiesRepository {

    override fun getCitiesByAutocomplete(q: String): Single<List<City>> {
        return forecastApi.getCitiesByNameFragment(APIKEY, q)
            .makeRequest(schedulerProvider, connectivityService)
            .map { it.map { cityResponse -> cityResponse.toCity() } }
            .onErrorReturn { emptyList() }
    }
}