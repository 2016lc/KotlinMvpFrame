package com.kotlinmvpframe.base.baselist

import com.kotlinmvpframe.base.BaseBean

/**
 * Created by LC on 2017/9/20.
 */
interface getModelImpl<A: BaseBean, out B:BaseListModelImpl<A>> {

    fun getMyModelImpl():B
}