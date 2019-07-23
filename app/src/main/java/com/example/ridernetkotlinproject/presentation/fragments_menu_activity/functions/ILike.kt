package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.functions

interface ILike <T>{
    fun changeHeart(obj: T):Int
    fun changeTxtNik(obj: T):String
    fun changeCountLikes(obj: T):String
}