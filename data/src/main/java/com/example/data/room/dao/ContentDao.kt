package com.example.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.storage.models.Model

@Dao
interface ContentDao {

    @Query("SELECT data FROM model WHERE data = :param")
    fun get(param: String): Model?

    @Insert
    fun save(content: Model)

    @Delete
    fun delete(content: Model)
}