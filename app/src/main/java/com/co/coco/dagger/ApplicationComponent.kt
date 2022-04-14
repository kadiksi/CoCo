package com.co.coco.dagger

import com.co.coco.MainApp
import com.co.coco.dagger.di.NavigationModule
import com.co.coco.dagger.module.*
import com.co.core.manager.ManagerCoreModule
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
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NavigationModule::class,
        ManagerCoreModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        FileModule::class,
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
