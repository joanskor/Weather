package com.joanna.weather.di

import com.joanna.weather.navigation.MainFlow
import com.joanna.weather.navigation.MainFlowImpl
import com.joanna.weather.navigation.NavigationService
import org.koin.dsl.module
import org.koin.experimental.builder.factoryBy
import org.koin.experimental.builder.single

/**
 * Created by Joanna on 17.05.2021
 */

val navigationModule = module {
    single<NavigationService>()
    factoryBy<MainFlow, MainFlowImpl>()
}