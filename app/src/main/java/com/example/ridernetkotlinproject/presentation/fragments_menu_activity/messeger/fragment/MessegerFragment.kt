package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger.model.Messeger
import com.example.ridernetproject.MessegerAdapter
import kotlinx.android.synthetic.main.fragment_message.*
import java.util.ArrayList

class MessegerFragment: Fragment() {

    fun newInstance(): Fragment{
        return MessegerFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_message, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        listMessage.layoutManager = LinearLayoutManager(context)

        val tables = ArrayList<Messeger>()
        tables.add(
            Messeger(
                "Игорь Петров",
                "Пока",
                "сегодня в 18:05",
                4
            )
        )
        tables.add(
            Messeger(
                "Виктор Петрович",
                "Ты мне за всё ответишь!",
                "сегодня в 17:00",
                100
            )
        )
        tables.add(Messeger())
        tables.add(Messeger())
        tables.add(Messeger())
        tables.add(Messeger())

        val tableAdapter = MessegerAdapter(tables)
        listMessage.setAdapter(tableAdapter)
        listMessage.addItemDecoration(DividerItemDecoration(context!!, LinearLayoutManager.VERTICAL))
    }
}


