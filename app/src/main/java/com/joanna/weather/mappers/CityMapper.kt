package com.joanna.weather.mappers

import com.joanna.weather.api.responses.CityResponse
import com.joanna.weather.models.City

/**
 * Created by Joanna on 17.05.2021
 */
fun CityResponse.toCity() : City = City(
    name = localizedName ?: "",
    country = country?.localizedName ?: "",
    key = key ?: ""
)