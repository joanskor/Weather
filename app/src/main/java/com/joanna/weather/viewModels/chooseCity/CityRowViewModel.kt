package com.joanna.weather.viewModels.chooseCity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joanna.weather.models.City

/**
 * Created by Joanna on 13.05.2021
 */
class CityRowViewModel(val city: City) {
    val name: LiveData<String> = MutableLiveData(city.name)
    val country: LiveData<String> = MutableLiveData(city.country)
}