package com.example.data.storage.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "model")
data class Model(
    @ColumnInfo(name = "data") @PrimaryKey(autoGenerate = false)
    @SerializedName("data") val data: String,
)
