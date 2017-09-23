package com.kotlinmvpframe.presenter

import com.kotlinmvpframe.base.BasePresenter
import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.mode.imlp.LoginModeImpl
import com.kotlinmvpframe.mode.LoginModel
import com.kotlinmvpframe.view.LoginView

/**
 * Created by LC on 2017/9/12.
 */
class LoginPresenterxx(val loginView: LoginView): BasePresenter<LoginView>() {

    var loginmode:LoginModel?=null

    init {
        loginmode= LoginModeImpl()
    }

    fun Login(username: String, password: String){
        loginmode!!.Login(username,password)

        loginmode!!.LoadComplete(object : LoginModel.OnLoginListener {
            override fun LoginSuccess(baseBean: BaseBean) {
                loginView.LoginSuccess(baseBean)
            }

            override fun LoginFailed(baseBean: BaseBean) {
                loginView.LoginFailed(baseBean)
            }
        })
    }
}