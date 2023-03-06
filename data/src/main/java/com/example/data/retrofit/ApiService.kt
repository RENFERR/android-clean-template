package com.example.data.retrofit

import com.example.data.storage.models.Model
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("example")
    fun getContent(
        @Query("param") param: String
    ): Response<Model>
}