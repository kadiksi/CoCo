package com.co.coco.dagger.module

import android.content.Context
import com.co.coco.BuildConfig.VERSION_NAME
import com.co.coco.MainApp
import com.co.coco.dagger.di.DataModule
import com.co.coco.model.Computer
import com.co.coco.model.Motherboard
import com.co.coco.model.Processor
import com.co.coco.model.RAM
import com.co.core.data.AppInfo
import com.co.core.data.BuildConfig
import com.co.core.data.ConfigManager
import com.co.core.manager.ConfigManagerImpl
import com.co.core.view.ContextProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Модули, который мы долджны передать в компонент
 */

@Module(includes = [ViewModelModule::class, DataModule::class])
class AppModule {

    @Provides
    @Singleton
    internal fun provideApplicationContext(app: MainApp): Context {
        return app
    }

    @Provides
    @Singleton
    internal fun provideContextProvider(contextProviderImpl: ContextProviderImpl): ContextProvider =
        contextProviderImpl

    /**
     * Предоставляет объекты
     */
    @Provides
    fun provideComputer(
        processor: Processor,
        motherboard: Motherboard,
        ram: RAM
    ): Computer {
        return Computer(
            processor = processor,
            motherboard = motherboard,
            ram = ram
        )
    }

    @Provides
    internal fun provideInfo(): AppInfo = AppInfo(
        appVersion = "123",
//        appName = BuildConfig.APP_NAME,
//        cryptoPublicKey = BuildConfig.PUBLICKEY,
//        dmsUrl = BuildConfig.API_DMS_URL,
//        apiUrl = BuildConfig.API_URL,
//        syncApiUrl = BuildConfig.API_SYNC_URL,
//        authUrl = BuildConfig.AUTH_SERVER_URL
    )

    @Provides
    fun provideProcessor(): Processor {
        return Processor()
    }

    @Provides
    fun provideMotherboard(): Motherboard {
        return Motherboard()
    }

    @Provides
    fun provideRam(): RAM {
        return RAM()
    }
}