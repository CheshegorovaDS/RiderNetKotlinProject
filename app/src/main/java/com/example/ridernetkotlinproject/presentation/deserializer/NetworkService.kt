package com.example.ridernetkotlinproject.presentation.deserializer

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//код для настройки библиотеки Retrofit.
class NetworkService {
    private var mInstance: NetworkService? = null
    private val BASE_URL = "http://api.armfriend.com/"
    private var mRetrofit: Retrofit
    private var client: OkHttpClient

    internal constructor(){
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        client = OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .build()

        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getInstance(): NetworkService {
        if (mInstance == null) {
            mInstance = NetworkService()
        }
        return mInstance as NetworkService
    }

    fun getJSONApi(): IServiceAPI {
        return mRetrofit.create(IServiceAPI::class.java)
    }

}