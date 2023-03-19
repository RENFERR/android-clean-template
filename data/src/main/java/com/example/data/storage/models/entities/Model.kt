package com.example.data.storage.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "model")
data class Model(
    @ColumnInfo(name = "data")
    @PrimaryKey(autoGenerate = false)
    val data: String,
)
