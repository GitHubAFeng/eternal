package com.app.afeng.afengapp

import android.content.Context
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Toast
import com.app.afeng.afengapp.network.OkClient
import okhttp3.Request


/**
 * Created by Administrator on 2017/5/31.
 */


fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun View.snackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this,message,duration).show()
}

fun View.snackbar(messageRes: Int, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this,messageRes,duration).show()
}

fun Any.log(message: String) {
    Log.e(this.javaClass.simpleName, message)
}

fun getHtml(url: String): String {
    val client = OkClient().instance
    val request = Request.Builder()
            .url(url)
            .build()

    val response = client.newCall(request).execute()
    return response.body().string()
}

fun WebView.load(html: String) {
    this.loadDataWithBaseURL("http://ishuhui.net/", html, "text/html", "charset=utf-8", null)
}