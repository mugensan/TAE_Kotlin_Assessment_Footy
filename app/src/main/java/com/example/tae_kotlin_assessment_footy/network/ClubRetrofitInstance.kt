package com.example.tae_kotlin_assessment_footy.network

import com.example.tae_kotlin_assessment_footy.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClubRetrofitInstance {
    val retrofitInstance: Retrofit
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return  Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_ID)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
}