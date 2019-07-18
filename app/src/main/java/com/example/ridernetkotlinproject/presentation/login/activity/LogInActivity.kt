package com.example.ridernetkotlinproject.presentation.login.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.check.CheckLogin
import com.example.ridernetkotlinproject.presentation.exten.nextActivity
import com.example.ridernetkotlinproject.presentation.menu.MenuActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registration.*
import java.util.regex.Pattern

class LogInActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       btnLogIn.setOnClickListener { checkLogin() }
    }

    fun checkLogin(){
        if(editTextPasswordLogin.length()>0 && CheckLogin().check(editTextEmailLogin.text.toString()) )
            nextActivity(MenuActivity::class.java)
        else
            Toast.makeText(this, "Неккоректные входные данные.", Toast.LENGTH_SHORT).show()
    }
}