package com.co.app.data

import com.co.core.data.Response

interface CoCoRepository {
    suspend fun getCities(): Response<List<City>>
}