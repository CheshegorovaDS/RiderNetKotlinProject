package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger

import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger.model.Messeger

interface IMessegerContact {
    interface View

    interface Presenter{
        fun loadMesseges(): List<Messeger>
    }
}