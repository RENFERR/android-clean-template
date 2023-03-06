package com.example.data.storage

import com.example.data.storage.models.Model
import com.example.data.storage.models.params.Params
import com.example.data.utils.Response

interface IStorage {
    suspend fun getContent(params: Params): Response<Model>
}

interface ILocalStorage : IStorage {
    suspend fun saveContent(content: Model): Response<Any>
    suspend fun deleteContent(content: Model): Response<Any>
}