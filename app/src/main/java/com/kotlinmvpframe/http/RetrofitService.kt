package com.kotlinmvpframe.http

import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.bean.MoneyDetailBean
import com.kotlinmvpframe.bean.MyPaperBean
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

/**
 * Created by Administrator on 2017/9/11.
 */
interface RetrofitService {

    //登录
    @FormUrlEncoded
    @POST("/app/common/login.html")
    fun getRegisterList(@FieldMap params: HashMap<String, String>): Observable<BaseBean>

    //我的论文
    @FormUrlEncoded
    @POST("/app/check/paperList.html")
    fun getPaperList(@FieldMap params: HashMap<String, String>): Observable<MyPaperBean>


    //资金明细
    @FormUrlEncoded
    @POST("/app/check/fundDetailList.html")
    fun getMoneyDetail(@FieldMap params: Map<String, String>): Observable<MoneyDetailBean>
}