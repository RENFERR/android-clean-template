package com.example.data.storage

import com.example.data.storage.models.Model
import com.example.data.storage.models.params.Params
import com.example.data.utils.Response

interface IStorage {
    suspend fun get(params: Params): Response<Model>

    interface INetwork : IStorage
    interface IDatabase : IStorage {
        suspend fun save(content: Model): Response<Unit>
        suspend fun delete(content: Model): Response<Unit>
    }
}