package com.example.retrofit.Client

import com.example.retrofit.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCilent {

    const val BASE_URL = "https://plans1.pythonanywhere.com/"

    fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitService(): RetrofitService {
        return getRetrofit().create(RetrofitService::class.java)
    }
}