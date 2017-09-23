package com.kotlinmvpframe.bean


import com.kotlinmvpframe.base.BaseBean


class NewsTopBean : BaseBean() {

    var result: ResultBean? = null

    class ResultBean {
        var stat: String? = null

        var data: List<DataBean>? = null

        class DataBean {
            var title: String? = null
            var date: String? = null
            var author_name: String? = null
            var thumbnail_pic_s: String? = null
            var thumbnail_pic_s02: String? = null
            var thumbnail_pic_s03: String? = null
            var url: String? = null
            var uniquekey: String? = null
            var type: String? = null
            var realtype: String? = null
        }
    }
}
