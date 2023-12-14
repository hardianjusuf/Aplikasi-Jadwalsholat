package com.d121211041.jadwalsholat.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Jadwal(
    val ashar: String,
    val date: String,
    val dhuha: String,
    val dzuhur: String,
    val imsak: String,
    val isya: String,
    val maghrib: String,
    val subuh: String,
    val tanggal: String,
    val terbit: String
): Parcelable
