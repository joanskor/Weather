package com.joanna.weather.common

import android.content.Context
import androidx.annotation.StringRes

/**
 * Created by Joanna on 18.05.2021
 */
interface ResourceProvider {
    fun getString(@StringRes id: Int): String
}

class ResourceProviderImpl(val context: Context) : ResourceProvider {
    override fun getString(id: Int): String = context.getString(id)
}