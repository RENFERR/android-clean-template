package com.example.data.storage.impl.database

import com.example.data.room.dao.ContentDao
import com.example.data.storage.IStorage
import com.example.data.storage.models.Model
import com.example.data.storage.models.params.Params
import com.example.data.utils.Mapper.map
import com.example.data.utils.Mapper.toEntity
import com.example.data.utils.Response
import com.example.data.utils.Request.safeRequest
import javax.inject.Inject

class DatabaseStorage @Inject constructor(
    private val contentDao: ContentDao
) : IStorage.IDatabase {

    override suspend fun get(params: Params): Response<Model> =
        safeRequest { contentDao.get(param = params.param)?.map() }

    override suspend fun save(content: Model): Response<Unit> =
        safeRequest { contentDao.save(content = content.toEntity()) }

    override suspend fun delete(content: Model): Response<Unit> =
        safeRequest { contentDao.delete(content = content.toEntity()) }
}