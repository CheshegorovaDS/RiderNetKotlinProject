package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.homepage

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.example.ridernetkotlinproject.presentation.exten.showPhoto
import com.example.ridernetkotlinproject.presentation.showPhoto.ShowPhotoActivity
import com.example.ridernetproject.User

class HomepagePresenter : IHomepageContact.Presenter{
    var view: HomepageFragment
    var model: HomepageModel

    val myUserId: Long = 135447

    constructor(view:HomepageFragment){
        this.view = view
        this.model = HomepageModel()
    }

    override fun isMyUser(id: Long) = id == myUserId

    override fun loadUser(id: Long) {
        view.hideProfile()

        model.loadUser(
            id = id,
            onSuccess = {
                if (isMyUser(id)) view.myProfile(it)
                else view.otherProfile(it)
            },
            onError = {
                Log.d("ServerError", it.message)
                view.errorConnection("Произошла ошибка при соединения.")
            }
        )
        view.showProfile()
    }

    override fun nextActivity(context: Context,photo: String) {
        var bundle = Bundle()
        bundle.putString("photo",photo)
        Fragment().showPhoto(context,ShowPhotoActivity::class.java,bundle)
    }
}