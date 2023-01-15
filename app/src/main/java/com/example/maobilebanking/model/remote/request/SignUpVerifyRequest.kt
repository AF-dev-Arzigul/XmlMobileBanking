package com.example.maobilebanking.model.remote.request

import com.google.gson.annotations.SerializedName

data class SignUpVerifyRequest(
    @SerializedName("token") val `token`: String,
    @SerializedName("code") val `code`: String
)
