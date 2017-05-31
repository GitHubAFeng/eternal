package com.app.afeng.afengapp.base

import android.app.Activity
import android.os.Bundle
import me.yokeyword.fragmentation.SupportActivity

/**
 * Created by AFeng on 2017/5/31.
 */
abstract class BaseActivity : SupportActivity() {

    lateinit var mContext: Activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

        mContext = this
        initView()

    }


    /**
     * 初始化布局
     */
    protected abstract fun getLayout(): Int

    /**
     * 初始化组件
     */
    protected abstract fun initView()


}