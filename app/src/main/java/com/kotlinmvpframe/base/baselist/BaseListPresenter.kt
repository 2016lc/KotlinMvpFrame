package com.kotlinmvpframe.base.baselist

import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.base.BasePresenter
import com.kotlinmvpframe.mode.ListModel
import com.kotlinmvpframe.mode.MoneyDetailModelImpl
import com.kotlinmvpframe.mode.imlp.ListModeImpl

/**
 * Created by LC on 2017/9/15.
 */
class BaseListPresenter<A:BaseBean,B:BaseListModelImpl<A>>(private val listViews: BaseListView,getModelImpl: getModelImpl<A, B>): BasePresenter<BaseListView>() {

    var listmodel: BaseListModel?=null
    //var mListModel:ListModel?=null
    //var F:BaseListModelImpl<BaseBean>?=null
    //var G:B?=
    init {
        listmodel= getModelImpl.getMyModelImpl()
    }


    //得到更多数据
    fun getMoreData(){
        listmodel!!.getMoreData()
    }
    //得到刷新数据
    fun getRefreshData(){
        listmodel!!.getRefreshDta()
        listmodel!!.loadComplete(object : BaseListModel.LoadComplete{
            override fun hasNoMoreData() {
                listViews.hasNoMoreData()
            }

            override fun getDataRefresh(mDatas: ArrayList<*>) {
                listViews.showRefresh(mDatas)
            }

            override fun getDataFailed(baseBean: BaseBean) {

            }

            override fun getDataMore(mDatas: ArrayList<*>) {
                listViews.loadMore(mDatas)
            }

        })
    }
}