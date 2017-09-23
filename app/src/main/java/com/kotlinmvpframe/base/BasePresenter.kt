package com.kotlinmvpframe.base

import java.lang.ref.WeakReference


/**
 * Created by LC on 2017/9/12.
 */
abstract class BasePresenter<T:BaseView> {

    var mViewRef:WeakReference<T>?=null

     fun attachView(view:T){
         mViewRef=WeakReference<T>(view)
     }

     fun detachView(){
         if(mViewRef!=null){
             mViewRef!!.clear()
             mViewRef==null
         }
     }
}