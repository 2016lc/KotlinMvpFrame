package com.kotlinmvpframe.mode

import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.base.baselist.BaseListModelImpl
import com.kotlinmvpframe.bean.MoneyDetailBean
import com.kotlinmvpframe.bean.NewsTopBean
import com.kotlinmvpframe.http.RetrofitManager
import rx.Observable

/**
 * Created by LC on 2017/9/19.
 */
class MoneyDetailModelImpl:BaseListModelImpl<NewsTopBean>() {

    override fun ServiceParams(params: HashMap<String, String>): Observable<NewsTopBean> {
        return RetrofitManager.builder().service!!.getNewTopList(params)
    }

    override fun SuccessOperation(o: BaseBean) {
        //super.SuccessOperation(o)
        val entity:NewsTopBean= o as NewsTopBean
        if(entity!=null){
            var datas:ArrayList<NewsTopBean.ResultBean.DataBean>?= entity.result!!.data as ArrayList<NewsTopBean.ResultBean.DataBean>?
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
        mParams!!.put("key", "6e72ebfc6449ee2c8d538797890099ea")
        return mParams
    }
}