package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.homepage

import com.example.ridernetkotlinproject.presentation.deserializer.NetworkService
import com.example.ridernetkotlinproject.presentation.model.user.UserResponse
import com.example.ridernetproject.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomepageModel : IHomepageContact {

    fun loadUser(id: Long, onSuccess: (User)->(Unit), onError: (Throwable)->(Unit)) {
        var user: User? = null
        NetworkService().getInstance()
            .getJSONApi()
            .getUser(id, "ZdhG1np0mO2bc5KgGQEFaGqnAdVNS520135447&1561622861046")
            .enqueue(object : Callback<UserResponse> {
                override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                    user = response.body()!!.response!!
                    onSuccess.invoke(user!!)
                }
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    onError.invoke(t)
                }
            })

    }
}