package com.example.ridernetkotlinproject.presentation.registration

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.exten.nextActivity
import com.example.ridernetkotlinproject.presentation.menu.MenuActivity
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity:AppCompatActivity(), IRegistrationContact.View{
    lateinit var presenter: RegistrationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        presenter = RegistrationPresenter(this)

        editTxtMotorbike.setOnClickListener { presenter.addMotorbyke() }
        btnRegistration.setOnClickListener {  presenter.checkRegistration(editTxtPassword.text.toString(),editTxtEmail.text.toString(),
            editTxtPhone.text.toString(), editTxtMotorbike.text.toString() )  }
    }

    override fun errorConnection(str: String) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
    }

    override fun changeActivity() {
        nextActivity(MenuActivity::class.java)
    }

    fun showListMotorbykes(list: List<String>){
        var bands: Array<String> = list.toTypedArray()
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