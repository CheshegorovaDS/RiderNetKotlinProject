package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.homepage

import android.content.Context
import com.example.ridernetproject.User

interface IHomepageContact {
    interface View{
       // fun updateProfile(id: Long)
        fun showProfile()
        fun hideProfile()
        fun otherProfile(user: User)
        fun myProfile(user: User)
        fun openPhoto(photo: String)
        fun errorConnection(str: String)
    }

    interface Presenter{
        fun loadUser(id: Long)
        fun nextActivity(context: Context,photo: String)
        fun isMyUser(id: Long): Boolean
    }
}