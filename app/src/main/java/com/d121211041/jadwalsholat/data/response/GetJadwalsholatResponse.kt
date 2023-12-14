package com.d121211041.jadwalsholat.data.response

import com.D121211041.jadwalsholat.data.models.Data
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GetJadwalsholatResponse(
    @SerialName("data")
    @Contextual
    val data: Data,
    @SerialName("status")
    val status: Boolean
)
