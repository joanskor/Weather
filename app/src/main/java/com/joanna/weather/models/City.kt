package com.joanna.weather.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Joanna on 14.05.2021
 */
@Parcelize
data class City (val name: String, val country: String, val key: String) : Parcelable