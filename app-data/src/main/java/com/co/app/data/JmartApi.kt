package com.co.app.data

import retrofit2.http.GET

interface JmartApi {

    @GET("_next/data/9zMAmYGHSYczBdq-mCFVW/index.json?lang=4")
    suspend fun getCities(): List<City>

}