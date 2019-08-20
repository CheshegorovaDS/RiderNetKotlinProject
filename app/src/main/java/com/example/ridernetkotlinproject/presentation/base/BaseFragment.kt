package com.example.ridernetkotlinproject.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ridernetkotlinproject.presentation.navigation.INavigation

abstract class BaseFragment : Fragment() {
    protected var navigation: INavigation? = null

    abstract val resLayout: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(resLayout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    abstract fun initView(view: View)
}