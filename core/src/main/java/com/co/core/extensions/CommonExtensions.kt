package com.co.core.extensions

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

@MainThread
inline fun <reified VM : ViewModel> Fragment.viewModelsParent(
    noinline factoryProducer: (() -> ViewModelProvider.Factory)? = null,
    noinline ownerProducer: () -> ViewModelStoreOwner = { requireParentFragment() }
) = createViewModelLazy(VM::class, { ownerProducer().viewModelStore }, factoryProducer)
