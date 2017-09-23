package com.kotlinmvpframe.view

import com.kotlinmvpframe.base.BaseView
import com.kotlinmvpframe.base.BaseBean

/**
 * Created by Administrator on 2017/9/8.
 */
interface LoginView :BaseView{

    fun getUserName(): String
    fun getPassWord(): String
    fun LoginSuccess(baseBean: BaseBean)
    fun LoginFailed(baseBean: BaseBean)

}