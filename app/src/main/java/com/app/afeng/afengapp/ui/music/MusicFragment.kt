package com.app.afeng.afengapp.ui.music

import android.os.Bundle
import com.app.afeng.afengapp.R
import com.app.afeng.afengapp.base.BaseFragment
import com.app.afeng.afengapp.ui.mv.MvFragment

/**
 * Created by Administrator on 2017/5/31.
 */
class MusicFragment : BaseFragment() {

    val mkey = "MusicFragment"

    companion object {
        fun newInstance(): MusicFragment {
            val fragment = MusicFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }


    /**
     * 初始化布局
     */
    override fun getLayoutId(): Int {
        return R.layout.fragment_music
    }


}