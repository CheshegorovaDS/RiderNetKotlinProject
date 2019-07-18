package com.example.ridernetkotlinproject.presentation.exten

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.nextActivity(nav:  Class<*>, arg: Bundle? = null ) {
    var intent = Intent(this,nav)
    startActivity(intent)
}