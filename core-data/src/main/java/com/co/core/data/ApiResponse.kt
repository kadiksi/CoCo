package com.co.core.data

import com.google.gson.annotations.SerializedName

data class ApiResponse<T : Any?>(
    val taskId: String? = null,
    val status: String? = null,
    val message: String? = null,
    @SerializedName("error_code")
    val errorCode: String? = null,
    val error: ApiError? = null,
    val data: T,
) {
    val isSuccessFul: Boolean
        get() = status == "success"

    val isSessionExpired: Boolean
        get() = errorCode == "95"
}

fun <T> ApiResponse<T>.toResponse(): Response<T> {
    return try {
        if (isSuccessFul) {
            Response.Success(data)
        } else {
            Response.Error(ApiException(this))
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Response.Error(e)
    }
}

inline val <T> ApiResponse<T>.asResponse: Response<T>
    get() = try {
        if (isSuccessFul) {
            Response.Success(data)
        } else {
            Response.Error(ApiException(this))
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Response.Error(e)
    }
