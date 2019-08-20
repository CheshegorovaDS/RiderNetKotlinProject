package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger.fragment

import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.base.AppFragment
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger.MessegerPresenter
import com.example.ridernetproject.MessegerAdapter
import kotlinx.android.synthetic.main.fragment_message.*

class MessegerFragment : AppFragment() {
    lateinit var presenter: MessegerPresenter

    override val resLayout: Int = R.layout.fragment_message

    fun newInstance(): Fragment{
        return MessegerFragment()
    }

    override fun initView(view: View) {
        listMessage.layoutManager = LinearLayoutManager(context)
        presenter = MessegerPresenter(this)
        listMessage.setAdapter(MessegerAdapter(presenter.loadMesseges()))
        listMessage.addItemDecoration(DividerItemDecoration(context!!, LinearLayoutManager.VERTICAL))
    }
}


