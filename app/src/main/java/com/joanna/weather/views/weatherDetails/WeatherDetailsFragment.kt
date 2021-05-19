package com.joanna.weather.views.weatherDetails

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import com.joanna.weather.R
import com.joanna.weather.adapters.RecyclerAdapter
import com.joanna.weather.viewModels.weatherDetails.ForecastRowViewModel
import com.joanna.weather.viewModels.weatherDetails.WeatherDetailsViewModel
import com.joanna.weather.views.BaseFragment
import kotlinx.android.synthetic.main.fragment_weather_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * Created by Joanna on 12.05.2021
 */
class WeatherDetailsFragment : BaseFragment<WeatherDetailsViewModel>() {
    override val layout: Int = R.layout.fragment_weather_details
    override val viewModel: WeatherDetailsViewModel by viewModel {
        val args = WeatherDetailsFragmentArgs.fromBundle(requireArguments())
        parametersOf(args.weather)
    }

    private val adapter = RecyclerAdapter(this, R.layout.listitem_forecast, RequestRowDiffCallback)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forecastRV.adapter = adapter
    }

    override fun bindObservables() {
        super.bindObservables()
        viewModel.forecastList.observe(viewLifecycleOwner, Observer {
            it?.let { adapter.submitList(it) }
        })
    }

    object RequestRowDiffCallback : DiffUtil.ItemCallback<ForecastRowViewModel>() {
        override fun areItemsTheSame(oldItem: ForecastRowViewModel, newItem: ForecastRowViewModel) =
            oldItem.forecast.date == newItem.forecast.date

        override fun areContentsTheSame(
            oldItem: ForecastRowViewModel,
            newItem: ForecastRowViewModel
        ) = oldItem.forecast == newItem.forecast
    }
}