package com.arch.mvvmjetpack.network

import com.arch.mvvmjetpack.data.news.NewsResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface APIHandler {
    @GET("svc/mostpopular/v2/viewed/1.json?api-key=Ld0AF7Vw0WXoTL5oGQSYPJGlb8PSrYrN")
    suspend fun getAllNews(): Response<NewsResponseModel>
}