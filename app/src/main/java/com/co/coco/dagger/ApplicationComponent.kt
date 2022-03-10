package com.co.coco.dagger

import com.co.coco.MainApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * С этого компонента будем получать зависимости
 */
@Singleton
@Component(modules = [AppModule::class, ActivityModule::class, AndroidSupportInjectionModule::class])
interface ApplicationComponent : AndroidInjector<MainApp>
