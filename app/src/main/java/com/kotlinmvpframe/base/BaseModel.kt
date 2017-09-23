package com.kotlinmvpframe.base

import com.kotlinmvpframe.http.RetrofitManager
import retrofit2.http.FieldMap
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Administrator on 2017/9/11.
 */
abstract class BaseModel <T:BaseBean>{

    var mParams:HashMap<String,String>?=HashMap()
    //var T:BaseBean?=null

    open fun PostParams(){
        ServiceParams(Params()!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (object : Subscriber<BaseBean>() {
                    override fun onCompleted() {
                        Completed()
                    }

                    override fun onError(e: Throwable?) {
                        FailedOperation(e)
                    }

                    override fun onNext(o: BaseBean) {
                       // val message = o.message
                        //mOnLoginListenr?.LoginSuccess()
                        SuccessOperation(o)
                    }
                })
    }

    open fun Completed() {

    }

    abstract fun FailedOperation(e: Throwable?)



    abstract fun SuccessOperation(o: BaseBean)


    abstract fun Params(): HashMap<String, String>?

   // open abstract fun ServiceParams():
    abstract fun ServiceParams(params: HashMap<String, String>): Observable<T>



    open fun ClearHashMap(){
        if (mParams!!.size>0)
            mParams!!.clear()
    }


}



