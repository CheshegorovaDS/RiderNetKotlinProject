package com.example.ridernetkotlinproject.presentation.login.activity

interface ILogInContract {
    interface View{
        fun errorConnention(r: String)
        fun changeActivity()
    }

    interface Presenter{
        fun checkLogIn(login: String, password: String)
    }

}