package com.llama.petmilly_client.data.model.temporary

import com.google.gson.annotations.SerializedName

data class TemporaryProtectionDTO(
    @SerializedName("data") val data: Boolean,
    @SerializedName("success") val success: Boolean,
)