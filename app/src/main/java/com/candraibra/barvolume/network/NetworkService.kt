package com.candraibra.barvolume.network

import com.candraibra.barvolume.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkService {

    private fun getNetwork(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.myjson.com/bins/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun getInterceptor(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        httpLoggingInterceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    fun getApi(): ApiService {
        return getNetwork().create(ApiService::class.java)
    }
}

