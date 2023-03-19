package com.example.data.storage.models.api

import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("data") val data: String,
)
