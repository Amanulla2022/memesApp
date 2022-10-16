package com.aman.androidcasestudymeme.modules


import com.google.gson.annotations.SerializedName

data class Memes(
    @SerializedName("data")
    val memeList: MemeList,

    @SerializedName("success")
    val success: Boolean
)