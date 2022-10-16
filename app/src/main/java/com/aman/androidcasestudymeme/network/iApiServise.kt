package com.aman.androidcasestudymeme.network

import com.aman.androidcasestudymeme.modules.Memes
import retrofit2.Response
import retrofit2.http.GET

interface iApiService {
    @GET(value ="get_memes")
    suspend fun getMeme() : Response<Memes>
}