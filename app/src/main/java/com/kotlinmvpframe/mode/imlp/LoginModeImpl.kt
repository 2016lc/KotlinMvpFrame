package com.kotlinmvpframe.mode.imlp

import com.kotlinmvpframe.base.BaseModel
import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.bean.NewsTopBean
import com.kotlinmvpframe.http.RetrofitManager
import com.kotlinmvpframe.mode.LoginModel
import rx.Observable


/**
 * Created by LC on 2017/9/8.
 */
class LoginModeImpl: LoginModel, BaseModel<NewsTopBean>() {
    override fun ServiceParams(params: HashMap<String, String>): Observable<NewsTopBean> {
        return RetrofitManager.builder().service!!.getNewTopList(params)
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
        if(o.reason=="成功的返回!"){
            mOnLoginListener!!.LoginSuccess(o)

        }else{
            mOnLoginListener!!.LoginFailed(o)
        }
    }
    override fun Params(): HashMap<String, String>? {
        ClearHashMap()
       // mParams!!.put("username",mUserName!!)
       // mParams!!.put("password",mPassWord!!)
        mParams!!.put("key", "6e72ebfc6449ee2c8d538797890099ea")
        return mParams
    }

    override fun Login(username: String, password: String) {
        mUserName=username
        mPassWord=password
        PostParams()

    }
}