package com.joanna.weather.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService

/**
 * Created by Joanna on 13.05.2021
 */
interface ConnectivityService {
    val isNetworkConnection: Boolean
}

class ConectivityServiceImpl(private val context: Context) : ConnectivityService {
    override val isNetworkConnection: Boolean
        get() = context.getSystemService<ConnectivityManager>()?.let {
            return@let if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) it.isNetworkConnection()
            else it.activeNetworkInfo?.isConnectedOrConnecting ?: false
        } ?: false

    @RequiresApi(Build.VERSION_CODES.M)
    private fun ConnectivityManager.isNetworkConnection(): Boolean {
        val activeNetwork = getNetworkCapabilities(activeNetwork) ?: return false
        return activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
    }
}