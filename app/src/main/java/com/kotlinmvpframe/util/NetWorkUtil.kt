package com.kotlinmvpframe.util

import android.content.Context
import android.net.ConnectivityManager
import com.kotlinmvpframe.MyApplication

/**
 * Created by Administrator on 2017/9/11.
 */
class NetWorkUtil {
    companion object {
        fun isNetWorkConnected(): Boolean {
            val cm = MyApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val currentNet = cm.activeNetworkInfo ?: return false
            return currentNet.isAvailable
        }
    }
}