package com.co.app.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
abstract class CoCoDataModule {

    @Binds
    abstract fun cocoRepo(coCoRepositoryImpl: CoCoRepositoryImpl): CoCoRepository

}

@Module
object CoCoDataNetworkModule {

    @Provides
    @Singleton
    internal fun provideJmartApi(
        retrofit: Retrofit.Builder,
        client: OkHttpClient,
    ): JmartApi {
        return create(JmartApi::class.java, retrofit, client)
    }

    private fun <T> create(
        service: Class<T>,
        retrofit: Retrofit.Builder,
        client: OkHttpClient,
        baseUrl: String = BuildConfig.JMART_API_URL
    ): T {
        val builder = client.newBuilder()
        return retrofit
            .baseUrl(baseUrl)
            .client(builder.build())
            .build()
            .create(service)
    }
}