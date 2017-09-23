/*
package com.kotlinmvpframe.presenter

import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.base.BasePresenter
import com.kotlinmvpframe.mode.ListModel
import com.kotlinmvpframe.mode.imlp.ListModeImpl
import com.kotlinmvpframe.view.ListViews

*/
/**
 * Created by LC on 2017/9/13.
 *//*

class ListPresenter(private val listViews: ListViews):BasePresenter<ListViews>() {

    var listmodel: ListModel?=null
    init {
        listmodel= ListModeImpl()
    }

    //得到更多数据
    fun getMoreData(){
        listmodel!!.getMoreData()
    }
    //得到刷新数据
    fun getRefreshData(){
        listmodel!!.getRefreshDta()
        listmodel!!.loadComplete(object :ListModel.LoadComplete{
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
}*/
