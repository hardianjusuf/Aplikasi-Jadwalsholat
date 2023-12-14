package com.d121211041.jadwalsholat.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Koordinat(
    val bujur: String,
    val lat: Double,
    val lintang: String,
    val lon: Double
): Parcelable
