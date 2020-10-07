package com.example.data.di

import android.content.Context
import com.example.data.datasourcess.remote.api.AuthInterceptor
import com.example.data.datasourcess.remote.api.BaseUrlConstant
import com.example.data.datasourcess.remote.api.MarvelApi
import com.example.data.datasourcess.remote.api.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @JvmStatic
    @Provides
    fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor()
    }

    @JvmStatic
    @Provides
    fun provideLogInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @JvmStatic
    @Provides
    fun provideNetworkConnectionInterceptor(context: Context): NetworkConnectionInterceptor {
        return NetworkConnectionInterceptor(context)
    }

    @JvmStatic
    @Provides
    fun provideOkHttpClient (
        logging:HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor,
        connectionInterceptor: NetworkConnectionInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(connectionInterceptor)
            .addInterceptor(logging)
            .addInterceptor(authInterceptor)
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofitMarvelApi(okHttpClient:OkHttpClient): MarvelApi {
        return Retrofit.Builder()
            .baseUrl(BaseUrlConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MarvelApi::class.java)
    }
}