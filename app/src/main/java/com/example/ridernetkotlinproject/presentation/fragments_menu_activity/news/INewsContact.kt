package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news

import android.content.Context
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.adapter.NewsAdapter

interface INewsContact {
    interface View{
        fun setFirstVisibleItem(item: Int)
        fun errorConnection(str: String)
        fun putLike()
    }

    interface Presenter{
        fun openPhoto(context: Context, photo: String)
        fun showNews()
        fun loadNews(tableAdapter: NewsAdapter, countVisibleItem:Int, firstVisibleItem: Int)
        fun putLike()
    }

}