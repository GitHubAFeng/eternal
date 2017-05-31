package com.app.afeng.afengapp.network

import okhttp3.OkHttpClient
import kotlin.properties.Delegates

/**
 * 单例
 * Created by Administrator on 2017/5/31.
 */
class OkClient : OkHttpClient() {
    var instance: OkClient by Delegates.notNull()

    init {
        instance = this
    }

}