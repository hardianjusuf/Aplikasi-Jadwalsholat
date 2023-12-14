package com.d121211041.jadwalsholat.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Data(
    val daerah: String?,
    val id: String?,
    val jadwal: List<Jadwal?>,
    val koordinat: Koordinat?,
    val lokasi: String?
): Parcelable