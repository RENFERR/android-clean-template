package com.example.data.retrofit

import com.example.data.storage.models.api.Model
import com.example.data.utils.ApiConfig.Requests.GetContent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(GetContent.path)
    fun getContent(
        @Query(GetContent.queryParam) param: String
    ): Response<Model>
}