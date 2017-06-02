package com.app.afeng.afengapp.ui.mv

import android.os.Bundle
import com.app.afeng.afengapp.R
import com.app.afeng.afengapp.base.BaseFragment


/**
 * Created by Administrator on 2017/5/31.
 */
class MvFragment : BaseFragment() {

    val mkey = "MvFragment"

    companion object {
        fun newInstance(): MvFragment {
            val fragment = MvFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    /**
     * 初始化布局
     */
    override fun getLayoutId(): Int {
        return R.layout.fragment_mv
    }


}