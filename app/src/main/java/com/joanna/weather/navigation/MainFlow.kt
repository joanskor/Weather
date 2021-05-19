package com.joanna.weather.navigation

import com.joanna.weather.R
import com.joanna.weather.models.Weather
import com.joanna.weather.views.chooseCity.ChooseCityFragmentDirections

/**
 * Created by Joanna on 17.05.2021
 */
interface MainFlow : Flow {
    fun showDetails(weather: Weather)
}

class MainFlowImpl(navigationService: NavigationService) : MainFlow,
    BaseFlow(navigationService, R.id.fragment) {
    override fun showDetails(weather: Weather) = navigateTo(
        ChooseCityFragmentDirections.actionChooseCityFragmentToWeatherDetailsFragment(weather)
    )
}
