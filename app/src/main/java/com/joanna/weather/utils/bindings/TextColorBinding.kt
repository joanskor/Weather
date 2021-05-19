package com.joanna.weather.utils.bindings

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Created by Joanna on 17.05.2021
 */
@BindingAdapter("app:temperatureColor")
fun TextView.setTextColor(temperature: Float) {
    this.setTextColor(getColorByTemperature(temperature))
}

private fun getColorByTemperature(temperature: Float): Int = when {
    temperature < 10 -> Color.BLUE
    temperature > 20 -> Color.RED
    else -> Color.BLACK
}