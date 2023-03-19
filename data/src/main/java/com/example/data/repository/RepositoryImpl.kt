package com.example.data.repository

import com.example.data.storage.impl.database.DatabaseStorage
import com.example.data.storage.impl.network.NetworkStorage
import com.example.data.utils.Mapper.map
import com.example.data.utils.Mapper.toDomainResponse
import com.example.data.utils.Mapper.toDomainUnitResponse
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
        val response = network.get(params = params.map())
        return response.toDomainResponse(mapper = { it.map() })
    }

    override suspend fun getLocalContent(params: Params): Response<Model> {
        val response = database.get(params = params.map())
        return response.toDomainResponse(mapper = { it.map() })
    }

    override suspend fun saveContent(content: Model): Response<Unit> {
        val response = database.save(content = content.map())
        return response.toDomainUnitResponse()
    }

    override suspend fun deleteContent(content: Model): Response<Unit> {
        val response = database.delete(content = content.map())
        return response.toDomainUnitResponse()
    }
}