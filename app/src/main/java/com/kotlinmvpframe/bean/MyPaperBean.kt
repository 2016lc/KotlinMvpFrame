package com.kotlinmvpframe.bean

import com.kotlinmvpframe.base.BaseBean

/**
 * Created by LC on 2017/9/14.
 */
class MyPaperBean:BaseBean() {
    var countOfCurrentPage: Int = 0
    var currentPage: Int = 0
    var totalCount: Int = 0
    var totalPage: Int = 0
    var pageResults: List<PageResultsBean>? = null

    class PageResultsBean {
        var id: Int = 0
        var createTime: String? = null
        var author: String? = null
        var title: String? = null
        var price: Int = 0
        var payStatus: Int = 0
        var orderNum: String? = null
        var productName: String? = null
        var handleStatus: Int = 0
    }
}