package com.joanna.weather.views.chooseCity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import com.joanna.weather.R
import com.joanna.weather.adapters.RecyclerAdapter
import com.joanna.weather.isValidCityName
import com.joanna.weather.viewModels.chooseCity.ChooseCityViewModel
import com.joanna.weather.viewModels.chooseCity.CityRowViewModel
import com.joanna.weather.views.BaseFragment
import kotlinx.android.synthetic.main.fragment_choose_city.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Created by Joanna on 11.05.2021
 */
class ChooseCityFragment : BaseFragment<ChooseCityViewModel>() {
    override val layout: Int = R.layout.fragment_choose_city
    override val viewModel: ChooseCityViewModel by viewModel()
    private val adapter = RecyclerAdapter(this, R.layout.listitem_city, RequestRowDiffCallback) {
        viewModel.showDetails(it.city)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foundCitiesRL.adapter = adapter
        setCityNameTextWatcher()
    }

    override fun bindObservables() {
        super.bindObservables()
        viewModel.cities.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
    }

    private fun setCityNameTextWatcher() {
        cityET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!s.toString().isValidCityName())
                    setNewCityName(s.toString().substring(0, (s.toString().length - 1)), this)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun setNewCityName(newCityName: String, textWatcher: TextWatcher) {
        cityET.removeTextChangedListener(textWatcher)
        cityET.setText(newCityName)
        cityET.setSelection(newCityName.length)
        cityET.addTextChangedListener(textWatcher)
    }

    object RequestRowDiffCallback : DiffUtil.ItemCallback<CityRowViewModel>() {
        override fun areItemsTheSame(oldItem: CityRowViewModel, newItem: CityRowViewModel) =
            oldItem.city.name == newItem.city.name

        override fun areContentsTheSame(oldItem: CityRowViewModel, newItem: CityRowViewModel) =
            oldItem.city == newItem.city
    }
}