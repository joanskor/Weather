package com.joanna.weather.di

import com.joanna.weather.common.*
import org.koin.dsl.module
import org.koin.experimental.builder.factoryBy

/**
 * Created by Joanna on 13.05.2021
 */
val commonModule = module {
    factoryBy<ResourceProvider, ResourceProviderImpl>()
    factoryBy<SchedulerProvider, SchedulerProviderImpl>()
    factoryBy<ConnectivityService, ConectivityServiceImpl>()
}