package com.co.coco.dagger.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        CoCoViewModelModule::class
    ]
)
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}