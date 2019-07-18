package com.example.ridernetkotlinproject.presentation.entry

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.exten.nextActivity
import com.example.ridernetkotlinproject.presentation.login.activity.LogInActivity
import com.example.ridernetkotlinproject.presentation.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_entry.*

class EntryActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        btnLoginEntry.setOnClickListener {
           // startActivity(Intent(this, LogInActivity::class.java))
            nextActivity(LogInActivity::class.java)
        }

        btnRegistrationEntry.setOnClickListener { nextActivity(RegistrationActivity::class.java) }
    }

}