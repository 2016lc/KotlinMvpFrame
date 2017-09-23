package com.kotlinmvpframe.base

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Toast
import com.kotlinmvpframe.R

/**
 * Created by LC on 2017/9/12.
 */

abstract class BaseActivity <V:BaseView,T :BasePresenter<V>>: FragmentActivity(),BaseView {
    //当前Activity渲染的视图View
    private var mContextView: View? = null
    private var progressDialog: Dialog? = null
    open var mPresenter:T?=null
    //private var mCenterText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置activity为无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        mContextView = LayoutInflater.from(this).inflate(bindLayout(), null)
        setContentView(mContextView)
        // 初始化ui
        initView()
        // 初始化数据
        initData()
        // 添加监听器
        initListener()
    }

    //布局绑定
    abstract fun bindLayout(): Int

    // 初始化ui
    @Suppress("UNCHECKED_CAST")
    protected open fun initView() {
        if(mPresenter==null){
            mPresenter=createPresenter()
        }
        mPresenter!!.attachView(this as V)
    }

    // 初始化数据
    protected abstract fun initData()

    // 添加监听器
    protected abstract fun initListener()


    // Toast
    fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    //activity跳转
    @JvmOverloads fun openActivity(targetActivityClass: Class<*>, bundle: Bundle? = null) {
        val intent = Intent(this, targetActivityClass)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    fun openActivity(targetActivityClass: Class<*>, targetName: String, targetMessage: String?) {
        val intent = Intent(this, targetActivityClass)
        if (targetMessage != null) {
            intent.putExtra(targetName, targetMessage)
        }
        startActivity(intent)
    }
    //activity跳转并关闭当前页面
    fun openActivityAndCloseThis(targetActivityClass: Class<*>, targetName: String, targetMessage: String) {
        openActivity(targetActivityClass, targetName, targetMessage)
        this.finish()
    }

    fun openActivityAndCloseThis(targetActivityClass: Class<*>) {
        openActivity(targetActivityClass)
        this.finish()
    }

    fun openActivityAndCloseThis(targetActivityClass: Class<*>, bundle: Bundle) {
        openActivity(targetActivityClass, bundle)
        this.finish()
    }

    //显示等待动画
    override fun LoadingShow() {
        progressDialog = Dialog(this, R.style.progress_dialog)
        progressDialog!!.setContentView(R.layout.dialog)
        progressDialog!!.setCancelable(true)
        progressDialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        progressDialog!!.setCanceledOnTouchOutside(false)
        progressDialog!!.show()
    }
    //隐藏等待动画
    override fun LoadingDis() {
        if (progressDialog != null && progressDialog!!.isShowing)
            progressDialog!!.dismiss()
    }

    //弹出原生交互界面
    fun AffirmDialogShow(title: String, content: String) {
        AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(title)
                .setMessage(content)
                .setNegativeButton("取消") { dialogInterface, i -> dialogInterface.dismiss() }
                .setPositiveButton("确认") { dialogInterface, i ->
                    okOperation()//点击确认操作
                    dialogInterface.dismiss()
                }.show()
    }

    abstract fun createPresenter():T

    protected open fun okOperation() {}

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.detachView()
        mContextView = null
      //  Log.i("xxxxxxxxxxxxxxx","xxxxxxxxxxxxxxxxxxx")
    }
}