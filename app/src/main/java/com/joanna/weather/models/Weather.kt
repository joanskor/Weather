package com.joanna.weather.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Joanna on 13.05.2021
 */
@Parcelize
data class Weather(
    val date: String,
    val temperature: Float,
    val unit: String,
    val icon: Int,
    val city: City
) : Parcelable