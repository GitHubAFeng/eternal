package com.app.afeng.afengapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.fragmentation.SupportFragment

/**
 * Created by AFeng on 2017/5/31.
 */
abstract class BaseFragment : SupportFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(getLayoutId(), null)
    }

    /**
     * 初始化布局
     */
    protected abstract fun getLayoutId(): Int
}