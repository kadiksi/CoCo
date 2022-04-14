package com.co.core.view

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun <T> MutableLiveData<T>.setValueAndClear(value: T) {
    setValue(value)
    setValue(null)
}

fun <T> LiveData<T>.setObserver(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    removeObservers(lifecycleOwner)
    observe(lifecycleOwner, observer)
}