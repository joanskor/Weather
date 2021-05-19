package com.joanna.weather.viewModels.chooseCity

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joanna.weather.BR
import com.joanna.weather.R
import com.joanna.weather.common.ResourceProvider
import com.joanna.weather.mappers.toWeather
import com.joanna.weather.models.City
import com.joanna.weather.navigation.MainFlow
import com.joanna.weather.repositories.CitiesRepository
import com.joanna.weather.repositories.WeatherRepository
import com.joanna.weather.viewModels.BaseViewModel

/**
 * Created by Joanna on 12.05.2021
 */

class ChooseCityViewModel(
    private val resourceProvider: ResourceProvider,
    private val citiesRepository: CitiesRepository,
    private val weatherRepository: WeatherRepository,
    private val mainFlow: MainFlow
) : BaseViewModel(), Observable {

    private val _cities = MutableLiveData<List<CityRowViewModel>>(emptyList())
    var cities: LiveData<List<CityRowViewModel>> = _cities
    private val propertyChangeRegistry = PropertyChangeRegistry()
    var cityName: String = ""
        @Bindable get
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.cityName)
            getCitiesByNameFragment(field)
        }

    private fun getCitiesByNameFragment(nameFragment: String) {
        citiesRepository.getCitiesByAutocomplete(nameFragment)
            .map { it.map { city -> CityRowViewModel(city) } }
            .subscribeWithDispose(
                onSuccess = { _cities.postValue(it) },
                onError = { setError(resourceProvider.getString(R.string.city_not_found_error)) }
            )
    }

    fun showDetails(city: City) {
        weatherRepository.getWeatherByLocationKey(city.key)
            .map { weatherResponse -> weatherResponse[0].toWeather(city) }
            .subscribeWithDispose(
                onSuccess = { mainFlow.showDetails(it) },
                onError = { setError(resourceProvider.getString(R.string.getting_weather_error)) }
            )
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }
}