package com.kotlinmvpframe.base.baselist

import com.kotlinmvpframe.base.BaseBean

/**
 * Created by LC on 2017/9/15.
 */
interface BaseListModel {

    fun getMoreData()//上拉加载

    fun getRefreshDta()//下拉刷新

    fun showNetError()//网络错误

    fun showDataError()//加载错误

    fun loadComplete(loadedListener: LoadComplete)//数据加载完成

    interface LoadComplete{
        fun getDataRefresh(mDatas:ArrayList<*>)
        fun getDataMore(mDatas:ArrayList<*>)
        fun getDataFailed(baseBean: BaseBean)
        fun hasNoMoreData()
    }
}