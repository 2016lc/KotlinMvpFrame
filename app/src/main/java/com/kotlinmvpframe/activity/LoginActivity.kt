package com.kotlinmvpframe.activity


import android.widget.Toast

import com.kotlinmvpframe.R
import com.kotlinmvpframe.base.BaseActivity
import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.presenter.LoginPresenterxx
import com.kotlinmvpframe.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginView,LoginPresenterxx>(),LoginView {

    override fun createPresenter(): LoginPresenterxx {
        return LoginPresenterxx(this)
    }


    override fun bindLayout(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        btn_login.setOnClickListener{

            LoadingShow()
            mPresenter?.Login(getUserName(),getPassWord())}
    }

    override fun initListener() {

    }

    override fun getUserName(): String {
        return "test"
    }

    override fun getPassWord(): String {
        return "111111"
    }

    override fun LoginSuccess(baseBean: BaseBean) {
        LoadingDis()
        openActivity(MoneyDetailActivity::class.java)
        Toast.makeText(this,"成功"+baseBean.message,Toast.LENGTH_SHORT).show()

    }

    override fun LoginFailed(baseBean: BaseBean) {
        LoadingDis()
        Toast.makeText(this,"失败"+baseBean.message,Toast.LENGTH_SHORT).show()

    }

}
