package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.homepage

import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.base.AppFragment
import com.example.ridernetkotlinproject.presentation.exten.hide
import com.example.ridernetkotlinproject.presentation.exten.show
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.adapter.NewsAdapter
import com.example.ridernetproject.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_homepage.*

class HomepageFragment : AppFragment() , NewsAdapter.NextHomepage, IHomepageContact.View{

    lateinit var presenter:HomepagePresenter
    private lateinit var userPhoto: String
    private var uid: Long = 0

    fun newInstance():Fragment{
        return HomepageFragment()
    }

    override val resLayout = R.layout.fragment_homepage

    override fun initView(view: View) {
        val tableAdapter = NewsAdapter()
        recyclerViewHomepage.adapter = tableAdapter
        recyclerViewHomepage.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

        presenter = HomepagePresenter(this)
        openHomepage(135447.toLong())
        presenter.loadUser(uid)

        imgAvatar.setOnClickListener({
            presenter.nextActivity(this.context!!,userPhoto)
        })
    }

    override fun otherProfile(user: User) {
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
    }

    override fun myProfile(user: User) {
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
    }

    override fun openHomepage(userId: Long?) {
        val id = arguments
        if (id == null) {
            uid = userId!!
        } else {
            uid = id.getLong("userId")
        }
    }

    override fun errorConnection(str: String) {
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show()
    }

    //override fun updateProfile(id: Long) {}

    override fun showProfile() {
        cardViewUserPage.show()
        progressBar.hide()
    }

    override fun hideProfile() {
        cardViewUserPage.hide()
        progressBar.show()
    }

    override fun openPhoto(photo: String) {}

}