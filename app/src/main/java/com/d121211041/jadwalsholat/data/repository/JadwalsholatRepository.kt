package com.d121211041.jadwalsholat.data.repository

import com.d121211041.jadwalsholat.data.response.GetJadwalsholatResponse
import com.d121211041.jadwalsholat.data.source.remote.ApiService

class JadwalsholatRepository(private val apiService: ApiService) {

    suspend fun getJadwalsholat(): GetJadwalsholatResponse {
        return apiService.getJadwalsholat()
    }
}