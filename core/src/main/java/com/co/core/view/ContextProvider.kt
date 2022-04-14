package com.co.core.view

import kotlin.coroutines.CoroutineContext

interface ContextProvider {

    val ui: CoroutineContext
}