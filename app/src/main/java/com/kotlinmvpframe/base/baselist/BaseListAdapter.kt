package com.kotlinmvpframe.base.baselist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList

/**
 * Created by LC on 2017/9/15.
 */
open class BaseListAdapter<T>(datas: ArrayList<T>,mLayoutId:Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas: ArrayList<T>? = null
    var mLayoutId:Int?=null
    var mContext: Context? = null
    private var mLayoutInflater:LayoutInflater?=null
    private var mContentView: View?=null
    private var onRecyclerViewItemClickListener: OnRecyclerViewItemChildClickListener? = null
    init {
        this.datas = datas
        this.mLayoutId = mLayoutId
    }

    //创建新View，被LayoutManager所调用
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        var baseViewHolder: BaseViewHolder? = null
       // var headerCount = 0
        this.mContext = parent.context
        this.mLayoutInflater = LayoutInflater.from(mContext)
        baseViewHolder = onCreateDefViewHolder(parent, viewType)

       /* if (parent is XRecyclerView) {
            headerCount = parent.headerViewCount
        }*/
        initItemClickListener(baseViewHolder)
        return baseViewHolder
    }

    private fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return createBaseViewHolder(parent, mLayoutId!!)
    }

    protected fun createBaseViewHolder(parent: ViewGroup, layoutResId: Int): BaseViewHolder {
        return if (mContentView == null) {
            BaseViewHolder(getItemView(layoutResId, parent))
        } else BaseViewHolder(mContentView)
    }

    protected fun getItemView(layoutResId: Int, parent: ViewGroup): View {
        return mLayoutInflater!!.inflate(layoutResId, parent, false)
    }

    private fun initItemClickListener(baseViewHolder: BaseViewHolder?) {
        if (onRecyclerViewItemClickListener != null) {
            baseViewHolder!!.itemView.setOnClickListener { v ->
                onRecyclerViewItemClickListener!!.onItemChildClick(this@BaseListAdapter, v,
                        baseViewHolder.layoutPosition)
            }
        }
    }


    //将数据与界面进行绑定的操作
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        convert(holder as BaseViewHolder,
                datas!![position], position, datas!!.size)
    }

    open  fun convert(holder: BaseViewHolder, t: T, position: Int, size: Int){}

    //获取数据的数量
    override fun getItemCount(): Int {
        return datas!!.size
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    /*class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mTextView: TextView = view.findViewById<View>(R.id.text) as TextView

    }*/

    val data: List<*>?
        get() = datas

    fun getItem(position: Int): T {
        return datas!![position]
    }

    fun setOnRecyclerViewItemChildClickListener(childClickListener: OnRecyclerViewItemChildClickListener) {
        this.onRecyclerViewItemClickListener = childClickListener
    }

    interface OnRecyclerViewItemChildClickListener {

        fun onItemChildClick(adapter: BaseListAdapter<*>, view: View, position: Int)

    }
}
