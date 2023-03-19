package com.example.data.storage.impl.network

import com.example.data.storage.models.Model as StorageModel
import com.example.data.retrofit.ApiService
import com.example.data.storage.IStorage
import com.example.data.storage.models.params.Params
import com.example.data.utils.Mapper.map
import com.example.data.utils.Mapper.toDataResponse
import com.example.data.utils.Response
import com.example.data.utils.Request.safeApiRequest
import javax.inject.Inject

class NetworkStorage @Inject constructor(
    private val api: ApiService,
) : IStorage.INetwork {

    override suspend fun get(params: Params): Response<StorageModel> =
        safeApiRequest { api.getContent(param = params.param) }
            .toDataResponse(mapper = { it.map() })

}