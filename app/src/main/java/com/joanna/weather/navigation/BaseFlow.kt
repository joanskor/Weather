package com.joanna.weather.navigation

import androidx.navigation.NavDirections

/**
 * Created by Joanna on 17.05.2021
 */
interface Flow {
    fun navigateBack()
}

abstract class BaseFlow(
    private val navigateService: NavigationService,
    private val navHostId: Int
) : Flow {
    protected fun navigateTo(navDirections: NavDirections) =
        NavigationCommand.NavigateToCommand(
            navDirections,
            navHostId
        ).let { navigateService.navigateTo(it) }

    override fun navigateBack() =
        navigateService.navigateBack(
            NavigationCommand.BackCommand(
                navHostId
            )
        )
}