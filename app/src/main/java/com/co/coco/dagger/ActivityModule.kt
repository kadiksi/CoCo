package com.co.coco.dagger

import com.co.coco.MainActivity
import com.co.coco.fragments.ContainerFragment
import com.co.coco.fragments.FirstFragment
import com.co.coco.fragments.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun containerFragment(): ContainerFragment

    @ContributesAndroidInjector
    abstract fun firstFragment(): FirstFragment

    @ContributesAndroidInjector
    abstract fun secondFragment(): SecondFragment

}