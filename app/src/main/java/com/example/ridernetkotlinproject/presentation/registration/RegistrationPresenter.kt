package com.example.ridernetkotlinproject.presentation.registration

import com.example.ridernetkotlinproject.presentation.check.CheckLogin
import com.example.ridernetkotlinproject.presentation.check.CheckPhone


class RegistrationPresenter: IRegistrationContact.Presenter {
    var view: RegistrationActivity
    var model: IRegistrationContact.Model

    constructor(view:RegistrationActivity){
        this.view = view
        this.model = RegistrationModel()
    }

    override fun checkRegistration(password: String, login: String, phone: String, motorbyke: String) {
        if (CheckLogin().check(login)
            && password.isNotEmpty()
            && CheckPhone().check(phone)
            && motorbyke.isNotEmpty())
            view.changeActivity()
        else view.errorConnection("Неккоректные входные данные.")

    }

    override fun loadUser() {
    }

    override fun addMotorbyke() {
        view.showListMotorbykes(model.loadMotorbykes())
    }
}