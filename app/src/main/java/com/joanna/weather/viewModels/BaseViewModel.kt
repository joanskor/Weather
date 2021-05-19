package com.joanna.weather.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import autodispose2.autoDispose
import autodispose2.recipes.AutoDisposeViewModel
import com.joanna.weather.utils.SingleLiveEvent
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Created by Joanna on 13.05.2021
 */
open class BaseViewModel : AutoDisposeViewModel() {
    private val _errorMessage = SingleLiveEvent<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun <T> Single<T>.subscribeWithDispose(
        onError: (Throwable) -> Unit = { Log.d("TAG", "Error") },
        onSuccess: (T) -> Unit = {}
    ): Disposable = autoDispose(this@BaseViewModel).subscribe(onSuccess, onError)

    protected fun setError(message: String) {
        _errorMessage.postValue(message)
    }
}