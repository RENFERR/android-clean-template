package com.example.data.storage.database

import com.example.data.room.dao.ContentDao
import com.example.data.storage.ILocalStorage
import com.example.data.storage.models.Model
import com.example.data.storage.models.params.Params
import com.example.data.utils.Response
import com.example.data.utils.Request.localRequest
import javax.inject.Inject

class DatabaseStorage @Inject constructor(
    private val contentDao: ContentDao
) : ILocalStorage {

    override suspend fun getContent(params: Params): Response<Model> =
        localRequest { contentDao.get(param = params.param) }

    override suspend fun saveContent(content: Model): Response<Any> =
        localRequest { contentDao.save(content = content) }

    override suspend fun deleteContent(content: Model): Response<Any> =
        localRequest { contentDao.delete(content = content) }
}