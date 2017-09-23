package com.kotlinmvpframe.http

import com.kotlinmvpframe.base.BaseBean
import com.kotlinmvpframe.bean.MoneyDetailBean
import com.kotlinmvpframe.bean.MyPaperBean
import com.kotlinmvpframe.bean.NewsTopBean
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

/**
 * Created by Administrator on 2017/9/11.
 */
interface RetrofitService {

    @FormUrlEncoded
    @POST("toutiao/index")
    fun getNewTopList(@FieldMap params: Map<String, String>): Observable<NewsTopBean>
}