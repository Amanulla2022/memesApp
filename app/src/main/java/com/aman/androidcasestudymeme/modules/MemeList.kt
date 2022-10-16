package com.aman.androidcasestudymeme.modules


import com.google.gson.annotations.SerializedName

data class MemeList(
    @SerializedName("memes")
    val memes: List<Meme>
)