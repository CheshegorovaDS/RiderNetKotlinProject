package com.example.ridernetkotlinproject.presentation.registration

interface IRegistrationContact {
    interface View{
        fun errorConnection(str: String)
        fun changeActivity()
    }

    interface Presenter{
        fun checkRegistration(password: String, login: String, phone: String, motorbykeBands: String)
        fun loadUser()
        fun addMotorbyke()
    }

    interface Model{
        fun loadMotorbykes():List<String>
    }
}