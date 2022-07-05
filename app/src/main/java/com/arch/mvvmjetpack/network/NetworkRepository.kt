package com.arch.mvvmjetpack.network

import com.arch.mvvmjetpack.data.news.NewsResponseModel
import com.arch.mvvmjetpack.database.ChitsAppDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val handler: APIHandler,
    private val appDataBase: ChitsAppDataBase
) {

    fun getAllNews(): Flow<BaseResult<NewsResponseModel, String>> {
        return flow {
            val allNews = handler.getAllNews()
            if (allNews.isSuccessful) {
                allNews.body()?.let { emit(BaseResult.Success(it)) }
                    ?: emit(BaseResult.Error("Empty Response"))
            } else {
                emit(BaseResult.Error("Empty response"))
            }
        }
    }
}