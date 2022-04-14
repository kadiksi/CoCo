package com.co.coco.dagger.module

import android.content.Context
import android.net.Uri
import com.co.app.data.BuildConfig
import com.co.app.data.CoCoDataNetworkModule
import com.co.core.data.ConfigManager
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(
    includes = [
        CoCoDataNetworkModule::class,
    ]
)
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        context: Context
    ): OkHttpClient {
        val builder = getOkHttpBuilder(30)
        setDebugParams(builder)
        return builder.build()
    }

    @Provides
    internal fun retrofit(
        client: OkHttpClient,
        configManager: ConfigManager
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(configManager.applyCustomServer(BuildConfig.JMART_API_URL))
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()
                )
            )
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
    }

    private fun getOkHttpBuilder(
        timeout: Long,
        builder: OkHttpClient.Builder? = null
    ): OkHttpClient.Builder {
        return builder ?: OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
    }

    private fun ConfigManager.applyCustomServer(url: String): String {
        val customServer = customServer
        if (BuildConfig.DEBUG && customServerEnabled && !customServer.isNullOrEmpty()) {
            return Uri.parse(url)
                .buildUpon()
                .scheme("http")
                .encodedAuthority(customServer)
                .toString()
        }
        return url
    }

    private fun setDebugParams(
        builder: OkHttpClient.Builder,
    ): OkHttpClient.Builder {
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        return builder
    }
}