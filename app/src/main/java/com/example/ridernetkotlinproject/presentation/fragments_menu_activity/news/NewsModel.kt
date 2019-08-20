package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news

import com.example.ridernetkotlinproject.presentation.deserializer.NetworkService
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.adapter.NewsAdapter
import com.example.ridernetkotlinproject.presentation.model.news.News
import com.example.ridernetkotlinproject.presentation.model.news.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsModel {
    var list: List<News>? = null

    fun loadNews(tableAdapter: NewsAdapter, countVisibleItem:Int, firstVisibleItem: Int, onSucess:(List<News>)->(Unit), onError:(Throwable)->(Unit)){
        NetworkService().getInstance()
            .getJSONApi()
            .getNewsWithID("q3F5HhydFZBae6Wft7JRmDbzFrJEa0TS135447&1561027082464", countVisibleItem, firstVisibleItem)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                   list =  response.body()!!.response
                      //  tableAdapter.list.addAll(it)
                       onSucess.invoke(list!!)

                    tableAdapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) { onError.invoke(t)}
            })
    }

    fun putLike(){
        //меняет данные на сервере
    }
}