package com.co.app.data

import com.co.core.data.Response
import javax.inject.Inject

class CoCoRepositoryImpl @Inject constructor(
    private val jmartApi: JmartApi,
) : CoCoRepository, BaseCoCoRepository() {

    override suspend fun getCities(): Response<List<City>> {
        return call {
            jmartApi.getCities()
        }
    }
}
