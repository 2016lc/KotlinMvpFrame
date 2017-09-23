package com.kotlinmvpframe.view

import com.kotlinmvpframe.base.BaseView
import com.kotlinmvpframe.base.BaseBean

/**
 * Created by LC on 2017/9/13.
 */
interface ListViews:BaseView {

    fun loadMore( data:ArrayList<*>)

    fun showRefresh(data: ArrayList<*>)

    fun hasNoMoreData()

}