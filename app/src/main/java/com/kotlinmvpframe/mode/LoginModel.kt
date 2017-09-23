package com.kotlinmvpframe.mode

import com.kotlinmvpframe.base.BaseBean


/**
 * Created by Administrator on 2017/9/8.
 */
interface LoginModel {
    //登录
    fun Login(username:String,password:String)
    fun LoadComplete(onLoginListener: OnLoginListener)
    interface OnLoginListener{
        fun LoginSuccess(baseBean: BaseBean)
        fun LoginFailed(baseBean: BaseBean)
    }
}