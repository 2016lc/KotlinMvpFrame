package com.kotlinmvpframe.activity

import com.kotlinmvpframe.R
import com.kotlinmvpframe.base.baselist.BaseListActivity
import com.kotlinmvpframe.base.baselist.BaseListModelImpl
import com.kotlinmvpframe.base.baselist.BaseViewHolder
import com.kotlinmvpframe.bean.MoneyDetailBean
import com.kotlinmvpframe.bean.NewsTopBean
import com.kotlinmvpframe.mode.MoneyDetailModelImpl

/**
 * Created by LC on 2017/9/19.
 */
class MoneyDetailActivity: BaseListActivity<NewsTopBean.ResultBean.DataBean,NewsTopBean,MoneyDetailModelImpl>() {


    var mo:MoneyDetailModelImpl?= MoneyDetailModelImpl()

    override fun getMyModelImpl(): MoneyDetailModelImpl {
       return mo!!
    }


    override fun getItemLayout(): Int {
        return R.layout.item
    }

    override fun fitDates(helper: BaseViewHolder, bean: NewsTopBean.ResultBean.DataBean, position: Int, size: Int) {
        helper.setText(R.id.text,bean.title)
    }
}