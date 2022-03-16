package com.co.coco.dagger

import com.co.coco.MainApp
import com.co.coco.dagger.di.NavigationModule
import com.co.coco.dagger.module.ActivityModule
import com.co.coco.dagger.module.AppModule
import com.co.coco.dagger.module.FileModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * С этого компонента будем получать зависимости
 */
@Singleton
@Component(
    modules = [
        AppModule::class,
        ActivityModule::class,
        AndroidSupportInjectionModule::class,
        NavigationModule::class,
        FileModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MainApp> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: MainApp): ApplicationComponent.Builder

        fun build(): ApplicationComponent
    }
}
