package com.joanna.weather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.joanna.weather.BR

/**
 * Created by Joanna on 13.05.2021
 */
open class RecyclerAdapter<T : Any>(
    private val lifecycleOwner: LifecycleOwner,
    private val layoutId: Int,
    diffUtilCallback: DiffUtil.ItemCallback<T>,
    private val onClickListener: ((T) -> Unit)? = null
) : ListAdapter<T, ViewHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val item = getItem(position)

            onClickListener?.let { root.setOnClickListener { it(item) } }
            setVariable(BR.viewModel, item)
            lifecycleOwner = this@RecyclerAdapter.lifecycleOwner
            executePendingBindings()
        }
    }
}

class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
