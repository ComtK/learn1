package com.example.learn1

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIS {

    @POST("/testUrl")
    @Headers("accept: application/json", "content-type/application")
    fun post_users(@Body jsonParams: PostModel): Call<PostResult>

    @GET("/testUrl")
    @Headers("accept: application/json", "content-type/application")
    fun get_users(): Call<HTTP_GET_Model>

    companion object {
        private const val BASE_URL = "http://1.1.1.1"
        fun create() : APIS {
            val gson : Gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIS::class.java)
        }
    }
}