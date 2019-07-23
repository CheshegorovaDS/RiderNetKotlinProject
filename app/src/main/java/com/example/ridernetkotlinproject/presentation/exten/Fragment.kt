package com.example.ridernetkotlinproject.presentation.exten

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat

fun  Fragment.showPhoto(nav:  Class<*>, arg: Bundle? = null){
    var intent = Intent(context,nav)
    if (arg!=null){
        intent.putExtras(arg)
        ContextCompat.startActivities(context!!, arrayOf(intent))
    }
}


