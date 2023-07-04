package com.example.facilities_assessment.network

import com.example.facilities_assessment.model.FacilitiesResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

var httpClientService = OkHttpClient.Builder()
    .connectTimeout(20, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .addInterceptor(interceptor)

const val BASE_URL = "https://my-json-server.typicode.com/iranjith4/"
private val retrofit = Retrofit.Builder()
    .client(httpClientService.build())
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface WebService {
    @GET("ad-assignment/db")
    fun getFacilitiesAsync(): Deferred<FacilitiesResponse>
}

object FacilitiesApi {
    val webService : WebService by lazy {
        retrofit.create(WebService::class.java)
    }
}