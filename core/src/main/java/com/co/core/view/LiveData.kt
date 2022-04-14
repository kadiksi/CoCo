package com.co.core.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.co.core.data.Response

class StatusMutableLiveData : MutableLiveData<Unit?>() {

    fun update() {
        value = Unit
        value = null
    }
}

typealias StatusLiveData = LiveData<Unit?>

class ErrorMutableLiveData : MutableLiveData<Response.Error?>() {

    fun setError(error: Response.Error?) {
        value = error
        value = null
    }
}