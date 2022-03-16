package com.co.coco

import android.app.Application
import com.co.coco.dagger.ApplicationComponent
import com.co.coco.dagger.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainApp : Application(), HasAndroidInjector {

    private lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        initApplicationComponent()
    }

    private fun initApplicationComponent() {
        this.applicationComponent = DaggerApplicationComponent.builder()
            .application(this)
            .build()
        applicationComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}