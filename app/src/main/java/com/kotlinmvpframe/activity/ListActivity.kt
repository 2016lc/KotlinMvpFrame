/*
package com.kotlinmvpframe.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.ListView
import com.jcodecraeer.xrecyclerview.ProgressStyle
import com.jcodecraeer.xrecyclerview.XRecyclerView

import com.kotlinmvpframe.R
import com.kotlinmvpframe.adapter.MyAdapter
import com.kotlinmvpframe.base.BaseActivity
import com.kotlinmvpframe.bean.MyPaperBean

import com.kotlinmvpframe.view.ListViews
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity<ListViews,ListPresenter>(),ListViews {


    var mAdapter:MyAdapter?=null
    var mList:ArrayList<MyPaperBean.PageResultsBean>?= ArrayList()

    override fun bindLayout(): Int {
        return R.layout.activity_list
    }

    override fun initData() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        mRecyclerview.layoutManager=layoutManager

        mRecyclerview.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader)
        mRecyclerview.setLoadingMoreProgressStyle(ProgressStyle.Pacman)
        mRecyclerview.setArrowImageView(R.drawable.iconfont_downgrey)
    }

    override fun initListener() {
        mRecyclerview.setLoadingListener(object :XRecyclerView.LoadingListener{
            override fun onLoadMore() {
                mPresenter!!.getMoreData()
            }

            override fun onRefresh() {
                //showToast("ssss")
                mPresenter!!.getRefreshData()
            }

        })
        mAdapter= MyAdapter(mList)
        mRecyclerview.adapter=mAdapter
        mRecyclerview.refresh()


    }
    @Suppress("UNCHECKED_CAST")
    override fun loadMore(data: ArrayList<*>) {
        mList!!.addAll(data as ArrayList<MyPaperBean.PageResultsBean>)
        mAdapter!!.notifyDataSetChanged()
        mRecyclerview.loadMoreComplete()
    }
    @Suppress("UNCHECKED_CAST")
    override fun showRefresh(data: ArrayList<*>) {
       // showToast("xxxxxxxxx")
        mList!!.addAll(data as ArrayList<MyPaperBean.PageResultsBean>)
        mAdapter!!.notifyDataSetChanged()
        mRecyclerview.refreshComplete()
    }

    override fun hasNoMoreData() {
        mRecyclerview.setNoMore(true)
        mAdapter!!.notifyDataSetChanged()
    }

    override fun createPresenter(): ListPresenter{
        return ListPresenter(this)
    }

}
*/
