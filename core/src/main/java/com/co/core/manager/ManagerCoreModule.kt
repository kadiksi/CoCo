package com.co.core.manager

import com.co.core.data.ConfigManager
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ManagerCoreModule {

    @Binds
    @Singleton
    abstract fun bindConfigManager(configManagerImpl: ConfigManagerImpl): ConfigManager
}