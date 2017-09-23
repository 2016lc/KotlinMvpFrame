package com.kotlinmvpframe.base.baselist

import android.util.Log
import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.base.BaseModel
import com.kotlinmvpframe.bean.MyPaperBean
import com.kotlinmvpframe.http.RetrofitManager
import com.kotlinmvpframe.mode.ListModel
import rx.Observable

/**
 * Created by LC on 2017/9/15.
 */
open class BaseListModelImpl<S:BaseBean>: BaseModel<S>(), BaseListModel {
    override fun ServiceParams(params: HashMap<String, String>): Observable<S> {

        return Observable.never()

    }

    var PAGE:Int?=1
    var loadListeners:BaseListModel.LoadComplete?=null
    var isMore:Boolean?=true

    override fun getMoreData() {
        PAGE = PAGE!!.plus(1)
        isMore=true
        PostParams()
    }

    override fun getRefreshDta() {
        PAGE=1
        isMore=false
        PostParams()
    }

    override fun showNetError() {

    }

    override fun showDataError() {

    }

    override fun loadComplete(loadedListener: BaseListModel.LoadComplete) {
        if(this.loadListeners==null){
            this.loadListeners=loadedListener

        }
    }

    override fun FailedOperation(e: Throwable?) {

    }

    override fun SuccessOperation(o: BaseBean) {

    }

    override fun Params(): HashMap<String, String>? {
        ClearHashMap()
        mParams!!.put("page", PAGE.toString())
        Log.i("xxx","xxxxxx")
        return mParams
    }


}