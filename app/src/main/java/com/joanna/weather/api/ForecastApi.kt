package com.joanna.weather.api

import com.joanna.weather.api.responses.CityResponse
import com.joanna.weather.api.responses.ForecastResponse
import com.joanna.weather.api.responses.WeatherResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Joanna on 13.05.2021
 */
interface ForecastApi {
    @GET("/locations/v1/cities/autocomplete?")
    fun getCitiesByNameFragment(
        @Query("apikey") apikey: String,
        @Query("q") q: String
    ): Single<List<CityResponse>>

    @GET("/currentconditions/v1/{locationKey}?")
    fun getWeatherByLocationKey(
        @Path("locationKey") locationKey: String,
        @Query("apikey") apikey: String
    ): Single<List<WeatherResponse>>

    @GET("/forecasts/v1/daily/5day/{locationKey}?")
    fun getForecastByLocationKey(
        @Path("locationKey") locationKey: String,
        @Query("apikey") apikey: String
    ): Single<ForecastResponse>
}