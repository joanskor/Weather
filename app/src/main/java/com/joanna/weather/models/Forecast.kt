package com.joanna.weather.models

/**
 * Created by Joanna on 17.05.2021
 */
data class Forecast(
    val date: Long?,
    val minTemperature: Float,
    val maxTemperature: Float,
    val unit: String,
    val icon: Int
)