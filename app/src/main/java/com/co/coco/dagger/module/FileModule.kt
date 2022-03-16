package com.co.coco.dagger.module

import android.content.Context
import android.content.SharedPreferences
import com.co.coco.MainApp
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class FileModule {

    @Provides
    @Singleton
    internal fun provideApplicationContext(app: MainApp): Context {
        return app
    }

    @Provides
    @Named("session")
    internal fun session(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PACKAGE_SESSION, Context.MODE_PRIVATE)
    }

    companion object {
        private const val SHARED_PACKAGE_SESSION = "session"
    }
}