package com.example.ridernetkotlinproject.presentation.menu

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.friends.FriendsFragment
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.homepage.HomepageFragment
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.map.MapFragment
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger.fragment.MessegerFragment
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.NewsFragment
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item->
        when(item.itemId){
            R.id.navigation_map -> {
                loadFragment(MapFragment().newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                loadFragment(NewsFragment().newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_message -> {
                loadFragment(MessegerFragment().newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_friends -> {
                loadFragment(FriendsFragment().newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_homepage -> {
                loadFragment(HomepageFragment().newInstance())
                return@OnNavigationItemSelectedListener true
            }
            else -> return@OnNavigationItemSelectedListener false;
        }
    }




    private fun loadFragment(fragment: Fragment) {
            val ft = supportFragmentManager.beginTransaction()
                .replace(R.id.fl_content, fragment)
            ft.commit()
        }


}