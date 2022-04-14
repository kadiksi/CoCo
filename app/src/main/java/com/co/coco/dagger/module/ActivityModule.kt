package com.co.coco.dagger.module

import androidx.lifecycle.ViewModel
import com.co.coco.MainActivity
import com.co.coco.fragments.ContainerFragment
import com.co.coco.fragments.FirstFragment
import com.co.coco.fragments.SecondFragment
import com.co.coco.network.CitiesViewModel
import com.co.core.util.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

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

@Module
abstract class CoCoViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CitiesViewModel::class)
    abstract fun city(viewModel: CitiesViewModel): ViewModel
}