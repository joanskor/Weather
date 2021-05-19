package com.joanna.weather

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Joanna on 17.05.2021
 */
private const val CITY_NAME_REGEX =
    "^([a-zA-Z]+(|-| |'|.))*[a-zA-Z]*\$"

fun Long.parseEpochToStringDate(): String = SimpleDateFormat("dd-MM-yyyy").format(Date(this * 1000))

fun String.isValidCityName() = Regex(CITY_NAME_REGEX).matches(this)