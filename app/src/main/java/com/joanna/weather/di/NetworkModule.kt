package com.joanna.weather.di

import com.joanna.weather.api.ForecastApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Joanna on 13.05.2021
 */
private const val TIMEOUT = 15_000L
private const val API_URL = "https://dataservice.accuweather.com"

val networkModule = module {
    factory {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    single { createOkHttpClient() }
    single { createCityService<ForecastApi>(okHttpClient = get(), moshi = get()) }
}


private fun createOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    return OkHttpClient.Builder()
        .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
        .addInterceptor(logging)
        .build()
}

private inline fun <reified T> createCityService(okHttpClient: OkHttpClient, moshi: Moshi): T =
    createWebService(
        okHttpClient,
        url = API_URL,
        factory = MoshiConverterFactory.create(moshi)
    )

private inline fun <reified T> createWebService(
    okHttpClient: OkHttpClient,
    url: String,
    factory: Converter.Factory
): T = Retrofit.Builder()
    .baseUrl(url)
    .client(okHttpClient)
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .addConverterFactory(factory)
    .build().create(T::class.java)