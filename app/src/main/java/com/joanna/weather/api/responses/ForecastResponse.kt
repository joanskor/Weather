package com.joanna.weather.api.responses

import com.squareup.moshi.Json

/**
 * Created by Joanna on 17.05.2021
 */
data class ForecastResponse(
    @Json(name = "Headline")
    val headline: Headline?,
    @Json(name = "DailyForecasts")
    val dailyForecasts: List<DailyForecast>?
)

data class Headline(
    @Json(name = "EffectiveDate")
    val effectiveDate: String?,
    @Json(name = "EffectiveEpochDate")
    val effectiveEpochDate: Long?,
    @Json(name = "Severity")
    val severity: Int?,
    @Json(name = "Text")
    val text: String?,
    @Json(name = "Category")
    val category: String?,
    @Json(name = "EndDate")
    val endDate: String?,
    @Json(name = "EndEpochDate")
    val endEpochDate: Long?,
    @Json(name = "MobileLink")
    val mobileLink: String?,
    @Json(name = "Link")
    val link: String?
)

data class DailyForecast(
    @Json(name = "Date")
    val endDate: String?,
    @Json(name = "EpochDate")
    val endEpochDate: Long?,
    @Json(name = "Temperature")
    val temperature: TemperatureMinMax?,
    @Json(name = "Day")
    val day: DayNight?,
    @Json(name = "Night")
    val night: DayNight?,
    @Json(name = "Sources")
    val sources: List<String>?,
    @Json(name = "MobileLink")
    val mobileLink: String?,
    @Json(name = "Link")
    val link: String?
)

data class TemperatureMinMax(
    @Json(name = "Minimum")
    val minimum: MinimumMaximum?,
    @Json(name = "Maximum")
    val maximum: MinimumMaximum?
)

data class MinimumMaximum(
    @Json(name = "Value")
    val value: Float?,
    @Json(name = "Unit")
    val unit: String?,
    @Json(name = "UnitType")
    val unitType: Int?
)

data class DayNight(
    @Json(name = "Icon")
    val icon: Int?,
    @Json(name = "IconPhrase")
    val iconPhrase: String?,
    @Json(name = "HasPrecipitation")
    val hasPrecipitation: Boolean?,
    @Json(name = "PrecipitationType")
    val precipitationType: String?,
    @Json(name = "PrecipitationIntensity")
    val precipitationIntensity: String?
)