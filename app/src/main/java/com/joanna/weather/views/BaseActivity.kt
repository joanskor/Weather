package com.joanna.weather.views

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.joanna.weather.navigation.NavigationCommand
import com.joanna.weather.navigation.NavigationService

/**
 * Created by Joanna on 16.05.2021
 */
abstract class BaseActivity(@LayoutRes layoutId: Int) : AppCompatActivity(layoutId) {

    protected abstract val navigationService: NavigationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigationService.navigation.observe(this) { navCommand ->
            when (navCommand) {
                is NavigationCommand.NavigateToCommand -> kotlin.runCatching {
                    findNavController(navCommand.navHostId).navigate(navCommand.navDirection)
                }
                is NavigationCommand.BackCommand -> findNavController(navCommand.navHostId).navigateUp()
            }
        }
    }
}