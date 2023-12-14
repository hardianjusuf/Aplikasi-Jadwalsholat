package com.d121211041.jadwalsholat.data.source.remote

import com.d121211041.jadwalsholat.data.response.GetJadwalsholatResponse
import retrofit2.http.GET

interface ApiService {

    @GET("v1/sholat/jadwal/1609/2021/04")
    suspend fun getJadwalsholat(
    ): GetJadwalsholatResponse
}