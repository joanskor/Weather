package com.joanna.weather.api.responses

import com.squareup.moshi.Json

/**
 * Created by Joanna on 17.05.2021
 */
data class WeatherResponse(
    @Json(name = "LocalObservationDateTime")
    val localObservationDateTime: String?,
    @Json(name = "EpochTime")
    val epochTime: Long?,
    @Json(name = "WeatherText")
    val weatherText: String?,
    @Json(name = "WeatherIcon")
    val weatherIcon: Int?,
    @Json(name = "HasPrecipitation")
    val hasPrecipitation: Boolean?,
    @Json(name = "PrecipitationType")
    val precipitationType: String?,
    @Json(name = "IsDayTime")
    val isDayTime: Boolean?,
    @Json(name = "Temperature")
    val temperature: Temperature?,
    @Json(name = "MobileLink")
    val mobileLink: String?,
    @Json(name = "Link")
    val link: String?
)

data class Temperature(
    @Json(name = "Metric")
    val metric: Unit?,
    @Json(name = "Imperial")
    val imperial: Unit?
)

data class Unit(
    @Json(name = "Value")
    val value: Float?,
    @Json(name = "Unit")
    val unit: String?,
    @Json(name = "UnitType")
    val unitType: Int?
)