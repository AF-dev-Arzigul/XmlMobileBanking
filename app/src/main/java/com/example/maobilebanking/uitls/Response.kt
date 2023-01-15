package com.example.maobilebanking.uitls

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("refresh-token")
	val refreshToken: String,

	@field:SerializedName("access-token")
	val accessToken: String
)
