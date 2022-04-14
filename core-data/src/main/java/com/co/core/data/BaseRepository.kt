package com.co.core.data

import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import retrofit2.HttpException


abstract class BaseRepository {

    fun <T> handleResponse(response: ApiResponse<T>): Response<T> {
        return try {
            if (response.isSuccessFul) {
                Response.Success(response.data)
            } else {
                Response.Error(ApiException(response))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Error(e)
        }
    }

    suspend fun <T> handleResponse(deferred: Deferred<ApiResponse<T>>): Response<T> {
        return try {
            handleResponse(deferred.await())
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Error(e)
        }
    }

    inline fun <T> execute(func: () -> ApiResponse<T>): Response<T> {
        try {
            return func().asResponse
        } catch (e: Exception) {
            if (e is HttpException) {
                try {
                    val apiResponse = Gson().fromJson(
                        e.response()?.errorBody()?.string(),
                        ApiResponse::class.java
                    )
                    return Response.Error(ApiException(apiResponse))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            return Response.Error(e)
        }
    }

    inline fun <reified T> repeat(
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
}