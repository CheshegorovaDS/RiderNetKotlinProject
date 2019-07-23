package com.example.ridernetkotlinproject.presentation.login.activity

class LogInPresenter : ILogInContract.ILogInPresenter{

    lateinit var logInActivity: LogInActivity
    lateinit var logInPresenter: LogInPresenter

    constructor(logInPresenter: LogInPresenter) {
        this.logInPresenter = logInPresenter
    }

    constructor(logInActivity: LogInActivity){
        this.logInActivity = logInActivity
    }

    override fun checkLogIn() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}