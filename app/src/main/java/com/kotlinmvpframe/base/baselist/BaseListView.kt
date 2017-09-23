package com.kotlinmvpframe.base.baselist

import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.base.BaseView

/**
 * Created by LC on 2017/9/15.
 */
interface BaseListView : BaseView {

    fun loadMore( data:ArrayList<*>)

    fun showRefresh(data: ArrayList<*>)

    fun hasNoMoreData()

   // fun getModelImpl()

  //  fun getDataType():ArrayList<*>
}
