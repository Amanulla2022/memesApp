package com.aman.androidcasestudymeme.modules

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "memes")
data class Meme(
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("box_count")
    val boxCount: Int,

    @SerializedName("height")
    val height: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("width")
    val width: Int
)

