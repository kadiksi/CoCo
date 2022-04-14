package com.co.core.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.co.core.data.Response
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext


abstract class BaseViewModel(private val contextProvider: ContextProvider) : ViewModel(),
    CoroutineScope {

    private val job = Job()

    private val loadingMutableLiveData = MutableLiveData<Boolean>()

    val loadingLiveData: LiveData<Boolean>
        get() = loadingMutableLiveData

    private val errorMutableLiveData = ErrorMutableLiveData()

    val errorLiveData: MutableLiveData<Response.Error?>
        get() = errorMutableLiveData

    override val coroutineContext: CoroutineContext
        get() = contextProvider.ui + job

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    fun cancel() {
        coroutineContext.cancelChildren()
        loadingMutableLiveData.value = false
    }

    protected inline fun <reified T> handleResponse(
        response: Response<T>,
        mutableLiveData: MutableLiveData<T>? = null,
        hideLoading: Boolean = true,
        onError: (Response.Error?) -> Unit = {},
        onSuccess: (T) -> Unit = {}
    ) {
        if (hideLoading) {
            hideLoading()
        }
        if (response is Response.Success) {
            onSuccess(response.data)
            mutableLiveData?.value = response.data
        } else {
            onError(response as? Response.Error)
            showError(response)
        }
    }

    protected inline fun <reified T> repeat(
        repeatCount: Int = 3,
        func: () -> Response<T>
    ): Response<T> {
        var count = 0
        var response: Response<T>? = null
        while (response !is Response.Success && count < repeatCount) {
            response = func.invoke()
            count++
        }
        return response ?: func.invoke()
    }

    protected inline fun <reified T> longPool(
        crossinline func: suspend () -> Response<T>,
        crossinline isValid: (T) -> Boolean,
        mutableLiveData: MutableLiveData<Response<T>?>,
        delay: Long = 10000L,
        crossinline onFinish: (T) -> Unit = {}
    ) {
        mutableLiveData.value = Response.Loading()
        launch {
            var repeat = true
            while (repeat) {
                when (val response = func.invoke()) {
                    is Response.Success -> {
                        if (isValid.invoke(response.data)) {
                            repeat = false
                            onFinish.invoke(response.data)
                            mutableLiveData.setValueAndClear(response)
                        } else {
                            delay(delay)
                        }
                    }
                    is Response.Error -> {
                        repeat = false
                        mutableLiveData.value = response
                    }
                }
            }
        }
    }

    protected fun showError(response: Response<Any?>) {
        Timber.e((response as? Response.Error)?.exception?.toString())
        errorMutableLiveData.setError(response as? Response.Error)
    }

    protected fun showLoading() {
        loadingMutableLiveData.value = true
    }

    protected fun hideLoading() {
        loadingMutableLiveData.value = false
    }

    val isLoading: Boolean
        get() = loadingMutableLiveData.value == true
}

