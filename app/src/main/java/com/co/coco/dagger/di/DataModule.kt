package com.co.coco.dagger.di

import com.co.app.data.CoCoDataModule
import dagger.Module


@Module(
    includes = [
        CoCoDataModule::class,
    ]
)
abstract class DataModule