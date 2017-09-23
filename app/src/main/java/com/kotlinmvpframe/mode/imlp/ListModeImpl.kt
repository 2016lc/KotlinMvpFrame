/*
package com.kotlinmvpframe.mode.imlp

import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.base.BaseModel
import com.kotlinmvpframe.bean.MyPaperBean
import com.kotlinmvpframe.http.RetrofitManager
import com.kotlinmvpframe.mode.ListModel
import retrofit2.http.POST
import rx.Observable

*/
/**
 * Created by LC on 2017/9/14.
 *//*

class ListModeImpl:BaseModel<MyPaperBean>(),ListModel {

    override fun ServiceParams(params: HashMap<String, String>): Observable<MyPaperBean> {
        return RetrofitManager.builder().service!!.getPaperList(params)
    }


    var PAGE:Int?=1
    var loadListeners:ListModel.LoadComplete?=null
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

    override fun loadComplete(loadedListener: ListModel.LoadComplete) {
        if(this.loadListeners==null){
            this.loadListeners=loadedListener

        }
    }

    override fun FailedOperation(e: Throwable?) {

    }

    override fun SuccessOperation(o: BaseBean) {
        val entity:MyPaperBean= o as MyPaperBean
        if(entity!=null){
            var datas:ArrayList<MyPaperBean.PageResultsBean>?= entity.pageResults as ArrayList<MyPaperBean.PageResultsBean>?
            if(datas!=null&&datas.size>0){
                if(isMore!!){
                    loadListeners!!.getDataMore(datas)
                }else{
                    loadListeners!!.getDataRefresh(datas)
                }
            }else{
                loadListeners!!.hasNoMoreData()
            }
        }else{

        }

    }

    override fun Params(): HashMap<String, String>? {
        ClearHashMap()
        mParams!!.put("page", PAGE.toString())
        return mParams
    }
}*/
