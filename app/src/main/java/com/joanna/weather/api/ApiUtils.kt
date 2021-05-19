package com.joanna.weather.api

import com.joanna.weather.common.ConnectivityService
import com.joanna.weather.common.SchedulerProvider
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

/**
 * Created by Joanna on 13.05.2021
 */
private const val TIMEOUT = 20_000L
const val APIKEY = "ycj899ACaOA3N1qhf5GaBqOtBZz21Z8c"

internal fun <T> Single<T>.makeRequest(
    schedulerProvider: SchedulerProvider,
    connectivityService: ConnectivityService
): Single<T> = observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())
    .timeout(TIMEOUT, TimeUnit.MILLISECONDS, Single.error(ApiException.NotRespondingException()))
    .checkConnectivity(connectivityService)

internal fun <T> Single<T>.checkConnectivity(connectivityService: ConnectivityService): Single<T> =
    if (connectivityService.isNetworkConnection) this else Single.error(ApiException.NoInternetConnectionException())
