package com.co.coco.dagger.module

import com.co.core.view.ContextProvider
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class ContextProviderImpl @Inject constructor() : ContextProvider {

    override val ui: CoroutineContext
        get() = Dispatchers.Main
}