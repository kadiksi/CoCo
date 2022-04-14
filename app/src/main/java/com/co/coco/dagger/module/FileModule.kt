package com.co.coco.dagger.module

import android.content.Context
import android.content.SharedPreferences
import com.co.coco.MainApp
import com.co.core.data.ConfigManager
import com.co.core.manager.ConfigManagerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class FileModule {

    @Provides
    @Singleton
    internal fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PACKAGE, Context.MODE_PRIVATE)
    }

    @Provides
    @Named("session")
    internal fun session(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PACKAGE_SESSION, Context.MODE_PRIVATE)
    }

    companion object {
        private const val SHARED_PACKAGE = "base_shared_preferences"
        private const val SHARED_PACKAGE_SESSION = "session"
    }
}