package com.joanna.weather.views

import com.joanna.weather.R
import com.joanna.weather.navigation.NavigationService
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(R.layout.activity_main) {
    override val navigationService: NavigationService by inject()
}