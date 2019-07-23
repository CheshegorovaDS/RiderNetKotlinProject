package com.example.ridernetkotlinproject.presentation.registration

interface IRegistrationContact {
    interface RegistrationActivity{
        fun errorConnection(str: String)
        fun changeActivity()
    }

    interface RegistrationPresenter{
        fun checkRegistration(password: String, login: String, motorbykeBand: String)
    }

    interface RegistrationModel{
        fun loadMotorbykes()
    }
}