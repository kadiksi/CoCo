package com.co.app.data

data class CoCoApiResponse<T: Any?>(
    val success: Boolean = false,
    val error: String? = null,
    val message: String? = null,
    val data: T
)