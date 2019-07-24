package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.deserializer.NetworkService
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.homepage.HomepageFragment
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.BaseFragment
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.adapter.NewsAdapter
import com.example.ridernetkotlinproject.presentation.model.news.NewsResponse
import com.example.ridernetkotlinproject.presentation.navigation.INavigation
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("ValidFragment")
class NewsFragment: BaseFragment, NewsAdapter.NextHomepage, NewsAdapter.GetCurrentPosition{
    lateinit var tableAdapter:NewsAdapter
    internal var countVisibleItem = 5
    internal var firstVisibleItem: Int = 0

    constructor()

    fun newInstance(): Fragment {
        return NewsFragment()
    }

    @SuppressLint("ValidFragment")
    constructor(navigation: INavigation) {
        this.navigation = navigation
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_news, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listNews.setLayoutManager(LinearLayoutManager(context))

        tableAdapter = NewsAdapter()
        listNews.setAdapter(tableAdapter)
        listNews.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        tableAdapter.nextHomepage =  this
        tableAdapter.getCurrentPosition = this

        NetworkService().getInstance()
            .getJSONApi()
            .getNewsWithID("q3F5HhydFZBae6Wft7JRmDbzFrJEa0TS135447&1561027082464", countVisibleItem, firstVisibleItem)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                    response.body()!!.response?.let { tableAdapter.list.addAll(it) }
                    tableAdapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {}
            })

    }

    override fun openHomepage(userId: Long?) {
        val id = Bundle()
        id.putLong("userId", userId!!)
        navigation!!.add(HomepageFragment(), id)
    }


    override fun getPosition(index: Int): Int {
        firstVisibleItem += 6
        NetworkService().getInstance()
            .getJSONApi()
            .getNewsWithID("q3F5HhydFZBae6Wft7JRmDbzFrJEa0TS135447&1561027082464", countVisibleItem, firstVisibleItem)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                    response.body()!!.response?.let { tableAdapter.list.addAll(it) }
                    tableAdapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {}
            })
        return index
    }

}