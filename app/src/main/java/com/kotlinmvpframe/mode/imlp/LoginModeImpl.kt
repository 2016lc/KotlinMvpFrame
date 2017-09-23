package com.kotlinmvpframe.mode.imlp

import com.kotlinmvpframe.base.BaseModel
import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.http.RetrofitManager
import com.kotlinmvpframe.mode.LoginModel
import rx.Observable


/**
 * Created by LC on 2017/9/8.
 */
class LoginModeImpl: LoginModel, BaseModel<BaseBean>() {
    override fun ServiceParams(params: HashMap<String, String>): Observable<BaseBean> {
        return RetrofitManager.builder().service!!.getRegisterList(params)
    }


    //var mOnLoginListenr:LoginPresenter.onLoginListener?=null
    var mOnLoginListener: LoginModel.OnLoginListener?=null
    var mUserName:String?=null
    var mPassWord:String?=null


    override fun FailedOperation(e: Throwable?) {

    }

    override fun LoadComplete(onLoginListener: LoginModel.OnLoginListener) {
        if(mOnLoginListener==null){
            mOnLoginListener=onLoginListener
        }
    }

    override fun SuccessOperation(o: BaseBean) {
       // val message = o.message
        if(o.success){
            mOnLoginListener!!.LoginSuccess(o)

        }else{
            mOnLoginListener!!.LoginFailed(o)
        }
    }
    override fun Params(): HashMap<String, String>? {
        ClearHashMap()
        mParams!!.put("username",mUserName!!)
        mParams!!.put("password",mPassWord!!)
        return mParams
    }

    override fun Login(username: String, password: String) {
        mUserName=username
        mPassWord=password
        PostParams()

    }
}