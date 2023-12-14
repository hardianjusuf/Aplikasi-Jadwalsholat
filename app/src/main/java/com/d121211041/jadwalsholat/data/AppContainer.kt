package com.d121211041.jadwalsholat.data

import com.d121211041.jadwalsholat.data.repository.JadwalsholatRepository
import com.d121211041.jadwalsholat.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val jadwalsholatRepository: JadwalsholatRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://api.myquran.com/"

    val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val jadwalsholatRepository: JadwalsholatRepository
        get() = JadwalsholatRepository(retrofitService)

}
