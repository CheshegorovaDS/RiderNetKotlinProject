package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.homepage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.deserializer.NetworkService
import com.example.ridernetkotlinproject.presentation.exten.showPhoto
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.adapter.NewsAdapter
import com.example.ridernetkotlinproject.presentation.model.user.UserResponse
import com.example.ridernetkotlinproject.presentation.showPhoto.ShowPhotoActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_homepage.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomepageFragment: Fragment() , NewsAdapter.NextHomepage{
    private var userPhoto: String? = null
    private var uid: Long = 0

    fun newInstance():Fragment{
        return HomepageFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_homepage, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewHomepage.setLayoutManager(LinearLayoutManager(context))
        val tableAdapter = NewsAdapter()
        recyclerViewHomepage.setAdapter(tableAdapter)
        recyclerViewHomepage.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

        card_view_user_page.setVisibility(View.INVISIBLE)
        progressBar.visibility = View.VISIBLE
        openHomepage(135447.toLong())

        imgAvatar.setOnClickListener(View.OnClickListener {
            var bundle = Bundle()
            bundle?.putString("photo",userPhoto)
            showPhoto(ShowPhotoActivity::class.java,bundle)
        })
    }

    override fun openHomepage(userId: Long?) {
        val id = arguments
        if (id == null) {
            uid = userId!!
        } else {
            uid = id.getLong("userId")
        }

        NetworkService().getInstance()
            .getJSONApi()
            .getUser(uid, "ZdhG1np0mO2bc5KgGQEFaGqnAdVNS520135447&1561622861046")
            .enqueue(object : Callback<UserResponse> {
                override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                    val user = response.body()!!.response

                    txtNameHomepage.setText(user!!.fullName)
                    txtModel.setVisibility(View.GONE)
                    txtYearAndCountry.setText(user!!.getCountryAndCity())
                    userPhoto = user.bigAvatar.toString()
                    if (userPhoto != null) {
                        Picasso.with(context) //передаем контекст приложения
                            .load(userPhoto)
                            .into(imgAvatar) //ссылка на ImageView
                    }
                    txtStatus.setText(user.status)
                    txtCountReting.setText(user.raiting.toString())
                    txtCountFriends.setText(user.friendCount.toString())
                    txtCountCheckins.setText(user.checkinsCount.toString())
                    txtCountSubscride.setText(user.subscribesCount.toString())
                    card_view_user_page.setVisibility(View.VISIBLE)
                    progressBar.visibility = View.INVISIBLE
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {}
            })

    }
}