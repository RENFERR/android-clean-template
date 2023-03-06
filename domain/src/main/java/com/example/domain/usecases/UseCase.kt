package com.example.domain.usecases

import com.example.domain.models.Model
import com.example.domain.models.params.Params
import com.example.domain.repository.IRepository
import com.example.domain.utils.Response
import java.net.ConnectException

class UseCase(
    private val repository: IRepository,
) {
    suspend fun getContent(params: Params): Response<Model> {
        val netResponse = repository.getNetworkContent(params = params)
        if (netResponse is Response.Error && netResponse.exception is ConnectException)
            return repository.getLocalContent(params = params)
        return netResponse
    }

    suspend fun saveContent(content: Model) = repository.saveContent(content = content)
    suspend fun deleteContent(content: Model) = repository.deleteContent(content = content)
}