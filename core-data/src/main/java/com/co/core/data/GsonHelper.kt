package com.co.core.data

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonHelper {

    val gson: Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    inline fun <reified T> String.jsonToObject(): T? {
        return try {
            gson.fromJson(this, T::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}