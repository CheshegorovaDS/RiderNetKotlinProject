package com.example.ridernetkotlinproject.presentation.model.news

import com.example.ridernetkotlinproject.presentation.model.news.News
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsResponse {
    @SerializedName("status")
    @Expose
    var status: Int? = null
    @SerializedName("response")
    @Expose
    var response: List<News>? = null
}