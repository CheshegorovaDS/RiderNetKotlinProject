package com.example.ridernetkotlinproject.presentation.registration

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.check.CheckLogin
import com.example.ridernetkotlinproject.presentation.check.CheckPhone
import com.example.ridernetkotlinproject.presentation.exten.nextActivity
import com.example.ridernetkotlinproject.presentation.menu.MenuActivity
import kotlinx.android.synthetic.main.activity_entry.*
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        editTxtMotorbike.setOnClickListener { chooseMotorbikeBand() }
        btnRegistration.setOnClickListener {  checkRegistration()  }
    }


    fun checkRegistration(){
        if (CheckLogin().check(editTxtEmail.text.toString())
            && editTxtPassword.text.length>0
            && CheckPhone().check(editTxtPhone.text.toString())
            && editTxtMotorbike.length()>0)
            nextActivity(MenuActivity::class.java)
        else
            Toast.makeText(this, "Неккоректные входные данные.", Toast.LENGTH_SHORT).show()
    }

    fun chooseMotorbikeBand(){
        val bands = arrayOf("Honda", "Suzuki", "Yamaha", "Viper", "Kawasaki")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Выберите марку мотоцикла").setCancelable(false)
            // добавляем одну кнопку для закрытия диалога
            .setNeutralButton("Назад") { dialog, id -> dialog.cancel() }
            .setPositiveButton("OK") { dialog, id -> }
            //переключатели
            .setSingleChoiceItems(bands, -1) {
                    dialog, item -> Toast.makeText(applicationContext, "Ваша марка мотоцикла: " + bands[item], Toast.LENGTH_SHORT).show()
                    editTxtMotorbike.setText(bands[item])
            }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}