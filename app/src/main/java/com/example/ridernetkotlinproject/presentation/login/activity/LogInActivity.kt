package com.example.ridernetkotlinproject.presentation.login.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.exten.nextActivity
import com.example.ridernetkotlinproject.presentation.exten.toast
import com.example.ridernetkotlinproject.presentation.menu.MenuActivity
import kotlinx.android.synthetic.main.activity_login.*

class LogInActivity :AppCompatActivity(), ILogInContract.View{
    lateinit var presenter: LogInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LogInPresenter(this)

        btnLogIn.setOnClickListener { presenter.checkLogIn(email.text.toString(), password.toString() ) }
    }

    override fun errorConnention(r: String) = toast(r)

    override fun changeActivity() = nextActivity(MenuActivity::class.java)

}