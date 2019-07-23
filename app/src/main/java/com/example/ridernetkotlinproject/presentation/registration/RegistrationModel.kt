package com.example.ridernetkotlinproject.presentation.registration

class RegistrationModel: IRegistrationContact.Model{

    constructor(){ }

    override fun loadMotorbykes(): List<String> {
        val bands = arrayOf("Honda", "Suzuki", "Yamaha", "Viper", "Kawasaki")
        return bands.asList()
    }
}