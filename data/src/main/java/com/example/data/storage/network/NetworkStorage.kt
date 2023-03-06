package com.example.data.storage.network

import com.example.data.retrofit.ApiService
import com.example.data.storage.IStorage
import com.example.data.storage.models.Model
import com.example.data.storage.models.params.Params
import com.example.data.utils.Response
import com.example.data.utils.Request.networkRequest
import javax.inject.Inject

class NetworkStorage @Inject constructor(
    private val api: ApiService,
) : IStorage {

    override suspend fun getContent(params: Params): Response<Model> =
        networkRequest { api.getContent(param = params.param) }

}