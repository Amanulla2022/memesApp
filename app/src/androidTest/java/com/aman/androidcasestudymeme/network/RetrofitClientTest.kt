package com.aman.androidcasestudymeme.network

import com.aman.androidcasestudymeme.diprovider.AppModule
import org.junit.Test
import retrofit2.Retrofit

class RetrofitClientTest {
    @Test
    fun testRetrofitInstance(){
        val instance:Retrofit = RetrofitClient().retrofit
        assert(instance.baseUrl().toString() == AppModule.providesBaseUrl())
    }
    @Test
    fun testMemesService(){
        val service =MemesService(RetrofitClient().retrofit)
        val response = service.getMeme().execute()
        val errorBody = response.errorBody()
        assert(errorBody == null)

        //Check for success body
        val responseWrapper = response.body()
        assert(responseWrapper != null)
        assert(response.code() == 200)
    }
}