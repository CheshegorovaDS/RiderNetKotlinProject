package com.example.ridernetkotlinproject.presentation.exten

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import android.widget.ViewFlipper

fun  Fragment.showPhoto(context: Context,nav:  Class<*>, arg: Bundle? = null){
    var intent = Intent(context,nav)
    if (arg!=null){
        intent.putExtras(arg)
        ContextCompat.startActivities(context!!, arrayOf(intent))
    }
}

fun Fragment.toast(text: String){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(resId: Int){
    Toast.makeText(context, getString(resId), Toast.LENGTH_SHORT).show()
}
