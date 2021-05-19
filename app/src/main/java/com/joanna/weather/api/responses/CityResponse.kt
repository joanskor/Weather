package com.joanna.weather.api.responses

import com.squareup.moshi.Json

/**
 * Created by Joanna on 13.05.2021
 */
data class CityResponse(
    @Json(name = "Version")
    val version: Int?,
    @Json(name = "Key")
    val key: String?,
    @Json(name = "Type")
    val type: String?,
    @Json(name = "Rank")
    val rank: Int?,
    @Json(name = "LocalizedName")
    val localizedName: String?,
    @Json(name = "Country")
    val country: Location?,
    @Json(name = "AdministrativeArea")
    val administrativeArea: Location?
)

data class Location(
    @Json(name = "ID")
    val id: String?,
    @Json(name = "LocalizedName")
    val localizedName: String?
)