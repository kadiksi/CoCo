package com.co.core.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiError(
    val type: String?,
    val code: String?,
    val title: String?,
    val message: String?
) : Parcelable {

    val showInfoForm: Boolean
        get() = type == "show_info_form"

//    val errorCode: ApiErrorCode?
//        get() = safeEnumValueOf<ApiErrorCode>(code)
}


enum class ApiErrorCode {
    UNKNOWN,
    TECHNICAL_SERVICES,
    EXCHANGE_NOT_SUFFICIENT_FUNDS
}