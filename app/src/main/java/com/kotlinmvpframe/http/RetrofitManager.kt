package com.kotlinmvpframe.http

import android.app.Application
import com.kotlinmvpframe.MyApplication
import com.kotlinmvpframe.http.okhttpcookie.PersistentCookieStore
import com.kotlinmvpframe.util.NetWorkUtil
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/9/11.
 */
class RetrofitManager : Interceptor {


    //长缓存有效期为7天
    val CACHE_STALE_LONG="60 * 60 * 24 * 7"

    var mOkHttpClient: OkHttpClient? = null

    var service: RetrofitService? = null



    init {
        initOkHttpclient()
        var retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(RetrofitService::class.java)

    }

    //相当于java中的静态内部类
    companion object {
        fun builder() :RetrofitManager {
            //  println(RetrofitManager.javaClass.classes)
            return RetrofitManager()
        }
    }


    //配置缓存策略
    fun initOkHttpclient() {
        //log信息拦截器
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        if (mOkHttpClient == null) {
            mOkHttpClient = OkHttpClient.Builder()
                  //    .cache(cache)
                    .retryOnConnectionFailure(true)
                    .addNetworkInterceptor(this)
                    .addInterceptor(this)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(10000L, TimeUnit.MILLISECONDS)//读操作超时时间
                    .cookieJar(CookiesManager())
                    .build()
        }
    }

    private inner class CookiesManager : CookieJar {
        private val cookieStore = PersistentCookieStore(MyApplication.getInstance().applicationContext)

        override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>?) {
            if (cookies != null && cookies.size > 0) {
                for (item in cookies) {
                    cookieStore.add(url, item)
                }
            }
        }

        override fun loadForRequest(url: HttpUrl): List<Cookie> {
            return cookieStore.get(url)
        }
    }



    //云端响应头拦截器，用来适配缓存策略
    override fun intercept(chain: Interceptor.Chain?): Response {
        var request = chain!!.request()
        if (!NetWorkUtil.isNetWorkConnected()) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
        }
        var response = chain.proceed(request)
        if (NetWorkUtil.isNetWorkConnected()) {
            var cacheControl: String = request.cacheControl().toString()
            return response.newBuilder().header("Cache-Control", cacheControl)
                    .removeHeader("Pragma").build()
        } else {
            return response.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_LONG)
                    .removeHeader("Pragma").build()
        }
    }
}