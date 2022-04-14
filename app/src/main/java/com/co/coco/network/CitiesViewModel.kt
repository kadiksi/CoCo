package com.co.coco.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.co.app.data.City
import com.co.app.data.CoCoRepository
import com.co.core.data.Response
import com.co.core.view.BaseViewModel
import com.co.core.view.ContextProvider
import com.co.core.view.setValueAndClear
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class CitiesViewModel @Inject constructor(
    private val repository: CoCoRepository,
    contextProvider: ContextProvider
) : BaseViewModel(contextProvider) {

    private val liveData = MutableLiveData<Response<List<City>>?>()

    val citiesLiveData: LiveData<Response<List<City>>?>
        get() = liveData

    fun getCities() {
        liveData.value = Response.Loading()
        launch {
            val response = repository.getCities()
            Timber.e(response.toString())
            liveData.setValueAndClear(response)
        }
    }

}