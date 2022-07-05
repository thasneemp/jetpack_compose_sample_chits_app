package com.arch.mvvmjetpack.data.news


import com.google.gson.annotations.SerializedName

data class NewsResponseModel(
    @SerializedName("copyright")
    var copyright: String?,
    @SerializedName("num_results")
    var numResults: Int?,
    @SerializedName("results")
    var results: List<Result>?,
    @SerializedName("status")
    var status: String?
)