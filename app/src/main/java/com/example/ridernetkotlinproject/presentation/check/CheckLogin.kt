package com.example.ridernetkotlinproject.presentation.check

import android.text.Editable
import java.util.regex.Pattern

class CheckLogin : ICheck {
    override fun check(str: String): Boolean {
       // val pattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$")
        val checkLogin = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$"
        return Pattern.matches(checkLogin, str)
    }
}