package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger

import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger.fragment.MessegerFragment
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger.model.Messeger

class MessegerPresenter: IMessegerContact.Presenter {
    var view: MessegerFragment
    var model: MessegerModel

    constructor(view: MessegerFragment){
        this.view = view
        model = MessegerModel()
    }

    override fun loadMesseges(): List<Messeger> {
        val tables = ArrayList<Messeger>()
        tables.add(Messeger("Игорь Петров", "Пока", "сегодня в 18:05", 4))
        tables.add(Messeger("Виктор Петрович", "Ты мне за всё ответишь!", "сегодня в 17:00", 100))
        tables.add(Messeger())
        tables.add(Messeger())
        tables.add(Messeger())
        tables.add(Messeger())
        return tables
    }
}