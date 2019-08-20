package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.deserializer.NetworkService
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.homepage.HomepageFragment
import com.example.ridernetkotlinproject.presentation.base.BaseFragment
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.INewsContact
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.NewsPresenter
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.adapter.NewsAdapter
import com.example.ridernetkotlinproject.presentation.model.news.NewsResponse
import com.example.ridernetkotlinproject.presentation.navigation.INavigation
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("ValidFragment")
class NewsFragment: BaseFragment, NewsAdapter.NextHomepage, NewsAdapter.GetCurrentPosition, INewsContact.View {
    lateinit var presenter:NewsPresenter
    lateinit var tableAdapter:NewsAdapter
    internal var countVisibleItem = 5
    internal var firstVisibleItem: Int = 0

    override val resLayout: Int = R.layout.fragment_news

    constructor()

    fun newInstance(): Fragment {
        return NewsFragment()
    }

    override fun initView(view: View) {
        listNews.setLayoutManager(LinearLayoutManager(context))
        tableAdapter = NewsAdapter()
        listNews.setAdapter(tableAdapter)
        listNews.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        tableAdapter.nextHomepage =  this
        tableAdapter.getCurrentPosition = this

        presenter = NewsPresenter(this)
        presenter.loadNews(tableAdapter, countVisibleItem, firstVisibleItem)

    }

    @SuppressLint("ValidFragment")
    constructor(navigation: INavigation) {
        this.navigation = navigation
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

    override fun setFirstVisibleItem(item: Int){
        firstVisibleItem = item
    }

    override fun errorConnection(str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT)
    }

    override fun putLike(){

    }

}





/*
setRecyclerViewScrollListener()
 private var lastVisibleItemPosition: Int = 0
    private lateinit var scrollListener: RecyclerView.OnScrollListener
 private fun setRecyclerViewScrollListener() {
       var scrollListener = object : RecyclerView.OnScrollListener() {
           override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
               super.onScrollStateChanged(listNews, newState)
               lastVisibleItemPosition ++
               val totalItemCount = listNews!!.layoutManager?.itemCount
               if (totalItemCount == lastVisibleItemPosition + 1) {
                   Log.d("MyTAG", "Load new list")
                   listNews.removeOnScrollListener(scrollListener)
               }
           }
       }
       listNews.addOnScrollListener(scrollListener)
   }*/
