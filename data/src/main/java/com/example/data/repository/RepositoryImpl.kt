package com.example.data.repository

import com.example.data.storage.database.DatabaseStorage
import com.example.data.storage.network.NetworkStorage
import com.example.data.utils.Mapper.map
import com.example.domain.models.Model
import com.example.domain.models.params.Params
import com.example.domain.repository.IRepository
import com.example.domain.utils.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val network: NetworkStorage,
    private val database: DatabaseStorage
) : IRepository {

    override suspend fun getNetworkContent(params: Params): Response<Model> {
        val response = network.getContent(params = params.map())
        return response.map()
    }

    override suspend fun getLocalContent(params: Params): Response<Model> {
        val response = database.getContent(params = params.map())
        return response.map()
    }

    override suspend fun saveContent(content: Model): Response<Any> {
        val response = database.saveContent(content = content.map())
        return response.map()
    }

    override suspend fun deleteContent(content: Model): Response<Any> {
        val response = database.deleteContent(content = content.map())
        return response.map()
    }
}