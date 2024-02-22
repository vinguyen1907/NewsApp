package com.loc.newsapp.data.remote

import com.loc.newsapp.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String,
    ) : NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String,
    ) : NewsResponse
}