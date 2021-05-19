package com.joanna.weather.navigation

import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import com.joanna.weather.utils.SingleLiveEvent

/**
 * Created by Joanna on 17.05.2021
 */

sealed class NavigationCommand(val navHostId: Int) {
    class NavigateToCommand(val navDirection: NavDirections, navHostId: Int) :
        NavigationCommand(navHostId)

    class BackCommand(navHostId: Int) : NavigationCommand(navHostId)
}

class NavigationService {
    private val _navigation =
        SingleLiveEvent<NavigationCommand>()
    val navigation: LiveData<NavigationCommand> = _navigation

    fun navigateTo(navCommand: NavigationCommand) = _navigation.postValue(navCommand)

    fun navigateBack(backCommand: NavigationCommand.BackCommand) = navigateTo(backCommand)
}