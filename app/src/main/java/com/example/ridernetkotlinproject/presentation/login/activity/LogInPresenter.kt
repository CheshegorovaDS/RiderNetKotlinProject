package com.example.ridernetkotlinproject.presentation.login.activity

import com.example.ridernetkotlinproject.presentation.check.CheckLogin
import kotlinx.android.synthetic.main.activity_login.*

class LogInPresenter : ILogInContract.Presenter{
    lateinit var view: ILogInContract.View


    constructor(view: ILogInContract.View){
        this.view = view
    }

    override fun checkLogIn(login: String, password: String) {
        if(password.isNotEmpty() && CheckLogin().check(login)) view.changeActivity()
        else view.errorConnention("Неккоректные входные данные.")
    }
}