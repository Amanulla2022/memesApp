package com.aman.androidcasestudymeme.network

import com.aman.androidcasestudymeme.modules.Memes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MemeEndPoint {
    @GET("/get_memes")
    fun getMeme(): Call<Response<Memes>>
}