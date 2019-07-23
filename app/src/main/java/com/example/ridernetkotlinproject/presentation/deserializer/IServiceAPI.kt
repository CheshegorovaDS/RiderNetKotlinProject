package com.example.ridernetkotlinproject.presentation.deserializer

import com.example.ridernetkotlinproject.presentation.model.news.News
import com.example.ridernetkotlinproject.presentation.model.news.NewsResponse
import com.example.ridernetkotlinproject.presentation.model.user.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IServiceAPI {

    @get:GET("/post/get_all")
    val allNews: Call<List<News>>

    @GET("/post/get_all?key")
    fun getNewsWithID(
        @Query("key") key: String,
        @Query("count") count: Int, @Query("offset") offset: Int
    ): Call<NewsResponse>

    @GET("/profile/get?key")
    fun getUser(
        @Query("uid") uid: Long,
        @Query("key") key: String
    ): Call<UserResponse>

    @GET("/post")
    fun getNewsOfUser(@Query("userId") id: Int): Call<List<News>>

    @POST("/post")
    fun newsData(@Body data: News): Call<News>

    @POST("/post/get_all?count=20&type=1&offset=0&city_id=0&sex=2&key=q3F5HhydFZBae6Wft7JRmDbzFrJEa0TS135447&1561027082464")
    fun allNews(@Query("count") count: Int): Call<News>
}