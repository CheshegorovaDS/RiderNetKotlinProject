package com.example.ridernetkotlinproject.presentation.model.user

import com.example.ridernetproject.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("status")
    @Expose
    var status: Int? = null
    @SerializedName("response")
    @Expose
    var response: User? = null
}