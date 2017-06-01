package com.app.afeng.afengapp.ui.music

import android.os.Bundle
import com.app.afeng.afengapp.R
import com.app.afeng.afengapp.base.BaseFragment

/**
 * Created by Administrator on 2017/5/31.
 */
class MusicDetails : BaseFragment() {

    val mkey = "MusicDetails"

    companion object {
        fun newInstance(): MusicDetails {
            val fragment = MusicDetails()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    /**
     * 初始化布局
     */
    override fun getLayoutId(): Int {
        return R.layout.fragment_music_details
    }


}