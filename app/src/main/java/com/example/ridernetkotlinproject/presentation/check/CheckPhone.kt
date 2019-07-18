package com.example.ridernetkotlinproject.presentation.check

import android.text.Editable
import java.util.regex.Pattern

class CheckPhone: ICheck {
    override fun check(str: String): Boolean {
        val checkPhone = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$"
        return Pattern.matches(checkPhone, str)
    }

}