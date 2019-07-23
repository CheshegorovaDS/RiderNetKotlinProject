package com.example.ridernetkotlinproject.presentation.login.activity

interface ILogInContract {
    interface ILogInView{
        fun showToast()
        fun getUserData()
        fun changeActivity()
    }

    interface ILogInPresenter{
        fun checkLogIn()
    }

    interface ILogInModel{

    }
}