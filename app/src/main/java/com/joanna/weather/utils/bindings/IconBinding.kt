package com.joanna.weather.utils.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.joanna.weather.R

/**
 * Created by Joanna on 17.05.2021
 */
@BindingAdapter("app:weatherIcon")
fun ImageView.setWeatherIcon(icon: Int) {
    this.setImageResource(iconMap[icon]!!)
}

private val iconMap: HashMap<Int, Int> = hashMapOf(
    1 to R.drawable.icon_1,
    2 to R.drawable.icon_2,
    3 to R.drawable.icon_3,
    4 to R.drawable.icon_4,
    5 to R.drawable.icon_5,
    6 to R.drawable.icon_6,
    7 to R.drawable.icon_7,
    8 to R.drawable.icon_8,
    11 to R.drawable.icon_11,
    12 to R.drawable.icon_12,
    13 to R.drawable.icon_13,
    14 to R.drawable.icon_14,
    15 to R.drawable.icon_15,
    16 to R.drawable.icon_16,
    17 to R.drawable.icon_17,
    18 to R.drawable.icon_18,
    19 to R.drawable.icon_19,
    20 to R.drawable.icon_20,
    21 to R.drawable.icon_21,
    22 to R.drawable.icon_22,
    23 to R.drawable.icon_23,
    24 to R.drawable.icon_24,
    25 to R.drawable.icon_25,
    26 to R.drawable.icon_26,
    29 to R.drawable.icon_29,
    30 to R.drawable.icon_30,
    31 to R.drawable.icon_31,
    32 to R.drawable.icon_32,
    33 to R.drawable.icon_33,
    34 to R.drawable.icon_34,
    35 to R.drawable.icon_35,
    36 to R.drawable.icon_36,
    37 to R.drawable.icon_37,
    38 to R.drawable.icon_38,
    39 to R.drawable.icon_39,
    40 to R.drawable.icon_40,
    41 to R.drawable.icon_41,
    42 to R.drawable.icon_42,
    43 to R.drawable.icon_43,
    44 to R.drawable.icon_44
)