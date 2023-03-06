package com.example.domain.repository

import com.example.domain.models.Model
import com.example.domain.models.params.Params
import com.example.domain.utils.Response

interface IRepository {
    suspend fun getNetworkContent(params: Params): Response<Model>
    suspend fun getLocalContent(params: Params): Response<Model>

    suspend fun saveContent(content: Model): Response<Any>
    suspend fun deleteContent(content: Model): Response<Any>
}