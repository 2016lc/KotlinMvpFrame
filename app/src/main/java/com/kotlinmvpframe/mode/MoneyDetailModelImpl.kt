package com.kotlinmvpframe.mode

import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.base.baselist.BaseListModelImpl
import com.kotlinmvpframe.bean.MoneyDetailBean
import com.kotlinmvpframe.http.RetrofitManager
import rx.Observable

/**
 * Created by LC on 2017/9/19.
 */
class MoneyDetailModelImpl:BaseListModelImpl<MoneyDetailBean>() {

    override fun ServiceParams(params: HashMap<String, String>): Observable<MoneyDetailBean> {
        return RetrofitManager.builder().service!!.getMoneyDetail(params)
    }

    override fun SuccessOperation(o: BaseBean) {
        //super.SuccessOperation(o)
        val entity:MoneyDetailBean= o as MoneyDetailBean
        if(entity!=null){
            var datas:ArrayList<MoneyDetailBean.PageResultsBean>?= entity.pageResults as ArrayList<MoneyDetailBean.PageResultsBean>?
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
}