package com.example.ridernetkotlinproject.presentation.showPhoto

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ridernetkotlinproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_show_photo.*

class ShowPhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_photo)

        Picasso.with(this)
            .load(intent.getStringExtra("photo"))
            .into(imgPhotoNews)
    }
}