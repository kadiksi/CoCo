package com.co.app.data

import com.co.core.data.BaseRepository
import com.co.core.data.GsonHelper.jsonToObject
import com.co.core.data.Response
import retrofit2.HttpException

abstract class BaseCoCoRepository : BaseRepository() {

    protected inline fun <T> call(func: () -> T): Response<T> {
        return try {
            Response.Success(func())
        } catch (e: HttpException) {
            e.asResponse ?: Response.Error(e)
        } catch (e: Exception) {
            Response.Error(e)
        }
    }

    protected inline fun <T> callExecute(func: () -> CoCoApiResponse<T>): Response<T> {
        return try {
            Response.Success(func().data)
        } catch (e: HttpException) {
            e.asResponse ?: Response.Error(e)
        } catch (e: Exception) {
            Response.Error(e)
        }
    }

    protected inline val HttpException.asResponse: Response.Error?
        get() {
            val body = response()?.errorBody()?.string()
            if (body != null) {
                val error = body.jsonToObject<CoCoError>()
                if (error != null) {
                    return Response.Error(CoCoException(error))
                }
            }
            return null
        }
}