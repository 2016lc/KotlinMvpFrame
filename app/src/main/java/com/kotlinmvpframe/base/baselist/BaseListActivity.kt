package com.kotlinmvpframe.base.baselist

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jcodecraeer.xrecyclerview.ProgressStyle
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.kotlinmvpframe.R
import com.kotlinmvpframe.base.BaseActivity
import com.kotlinmvpframe.base.BaseBean
import kotlinx.android.synthetic.main.activity_list.*

/**
 * Created by LC on 2017/9/15.
 */
abstract class BaseListActivity<H,A:BaseBean,B:BaseListModelImpl<A>>: BaseActivity<BaseListView, BaseListPresenter<A,B>>(), BaseListView ,getModelImpl<A,B>{

    var mAdapter: BaseListAdapter<H>?=null
    var mList:ArrayList<H>?= ArrayList()


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
        mRecyclerview.setLoadingListener(object : XRecyclerView.LoadingListener{
            override fun onLoadMore() {
                mPresenter!!.getMoreData()
            }

            override fun onRefresh() {
                mPresenter!!.getRefreshData()
            }

        })
        if(mAdapter==null){
            mAdapter= object :BaseListAdapter<H>(mList!!,getItemLayout()){
                override fun convert(helper: BaseViewHolder, item: H, position: Int, size: Int) {
                    fitDates(helper, item, position, size)
                }
            }
            mRecyclerview.adapter=mAdapter
            mRecyclerview.refresh()

        }else{
            mAdapter!!.notifyDataSetChanged()
        }

        mAdapter!!.setOnRecyclerViewItemChildClickListener(object : BaseListAdapter.OnRecyclerViewItemChildClickListener {
            override fun onItemChildClick(adapter: BaseListAdapter<*>, view: View, position: Int) {
               // view.setBackgroundResource(R.drawable.clickfinish)
                onItemClick(view, position)

            }
        })

    }


    override fun loadMore(data: ArrayList<*>) {
        mList!!.addAll(data as ArrayList<H>)
        mAdapter!!.notifyDataSetChanged()
        mRecyclerview.loadMoreComplete()
    }

    @Suppress("UNCHECKED_CAST")
    override fun showRefresh(data: ArrayList<*>) {
        mList!!.clear()
        mList!!.addAll(data as ArrayList<H>)
        mAdapter!!.notifyDataSetChanged()
        mRecyclerview.refreshComplete()
    }

    override fun hasNoMoreData() {
        mRecyclerview.setNoMore(true)
        mAdapter!!.notifyDataSetChanged()
    }

    override fun createPresenter(): BaseListPresenter<A,B>{
        return BaseListPresenter(this,this)
    }



   // abstract fun mArrayList():ArrayList<*>
    abstract fun getItemLayout():Int//得到item布局


    protected abstract fun fitDates(helper: BaseViewHolder, bean: H, position: Int, size: Int)//数据匹配

    protected open fun onItemClick(v: View, position: Int) {

    }//item点击事件

    //abstract fun getModelImpl():BaseListModelImpl

}