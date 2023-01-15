package com.example.maobilebanking.uitls

import com.google.gson.annotations.SerializedName

data class UpdateTokenResponse(
    @SerializedName("access-token")
    val `refresh-token`: String,
    @SerializedName("refresh-token")
    val `access-token`: String
)
