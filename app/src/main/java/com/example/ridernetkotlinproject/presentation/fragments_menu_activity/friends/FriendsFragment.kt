package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.friends

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ridernetkotlinproject.R

class FriendsFragment: Fragment() {

    fun newInstance(): Fragment{
        return FriendsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }
}