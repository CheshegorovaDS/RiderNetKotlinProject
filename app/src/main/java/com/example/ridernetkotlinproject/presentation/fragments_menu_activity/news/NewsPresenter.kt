package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.ridernetkotlinproject.presentation.exten.showPhoto
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.adapter.NewsAdapter
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.fragment.NewsFragment
import com.example.ridernetkotlinproject.presentation.showPhoto.ShowPhotoActivity

class NewsPresenter: INewsContact.Presenter {
    var view:NewsFragment
    var model:NewsModel

    constructor(view:NewsFragment){
        this.view = view
        model = NewsModel()
    }

    override fun openPhoto(context: Context, photo: String) {
        var bundle = Bundle()
        bundle.putString("photo",photo)
        Fragment().showPhoto(context, ShowPhotoActivity::class.java,bundle)
    }

    override fun showNews() {

    }

    override fun loadNews(tableAdapter:NewsAdapter, countVisibleItem:Int, firstVisibleItem: Int) {
        model.loadNews(tableAdapter, countVisibleItem, firstVisibleItem,
            onSucess = {
                tableAdapter.list.addAll(it)},
            onError = {
                view.errorConnection("Произошла ошибка при соединения.")
            }
        )
        view.setFirstVisibleItem(firstVisibleItem+6)

    }

    override fun putLike() {
       // view.putLike()
        model.putLike()//изменение данных в сервере

    }
}