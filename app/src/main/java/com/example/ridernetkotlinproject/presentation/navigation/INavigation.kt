package com.example.ridernetkotlinproject.presentation.navigation

import android.os.Bundle
import android.support.v4.app.Fragment

interface INavigation {
    fun add(fragment: Fragment, bundle: Bundle)
    fun remove(fragment: Fragment)
    fun replace(fragment: Fragment, bundle: Bundle)
}