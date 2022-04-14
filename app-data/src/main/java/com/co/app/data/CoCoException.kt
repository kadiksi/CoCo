package com.co.app.data

data class CoCoException(val error: CoCoError) : Exception()

data class CoCoError(
    val status: Int?,
    val message: String?
) {
    val isSessionExpired: Boolean
        get() = status == 403
}