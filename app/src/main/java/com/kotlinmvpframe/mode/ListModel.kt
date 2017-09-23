package com.kotlinmvpframe.mode

import android.graphics.drawable.Icon
import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.bean.MyPaperBean

/**
 * Created by LC on 2017/9/14.
 */
interface ListModel {

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