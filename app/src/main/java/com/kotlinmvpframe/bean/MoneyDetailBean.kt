package com.kotlinmvpframe.bean

import com.google.gson.annotations.SerializedName
import com.kotlinmvpframe.base.BaseBean


/**
 * Created by 千里一醉 on 2017/1/19.
 */

class MoneyDetailBean : BaseBean() {

    /**
     * data : {"allTypes":{"0":"充值","1":"加款","2":"扣款","3":"提现","4":"付款"},"allStatuss":{"1":"成功","2":"失败","3":"冻结","4":"处理中","5":"作废"}}
     * pageResults : [{"id":71653,"createTime":"2017-03-09 16:36:01","currentMoney":null,"title":"微信充值","status":4,"money":0.1,"orderNum":"1703091636019475","type":0,"comments":"微信充值","beforeMoney":null},{"id":66363,"createTime":"2017-03-08 17:11:28","currentMoney":null,"title":"支付宝支付","status":4,"money":1,"orderNum":"1703081711285122","type":0,"comments":"APP","beforeMoney":null},{"id":65288,"createTime":"2017-03-08 13:57:29","currentMoney":null,"title":"微信充值","status":4,"money":1,"orderNum":"1703081357290010","type":0,"comments":"微信充值","beforeMoney":null},{"id":61098,"createTime":"2017-03-07 16:51:19","currentMoney":19569.04,"title":"兔兔","status":1,"money":1.3,"orderNum":"1703071651024629","type":2,"comments":"检测扣费","beforeMoney":19570.34},{"id":60919,"createTime":"2017-03-07 16:18:51","currentMoney":19570.34,"title":"兔兔","status":1,"money":1.3,"orderNum":"1703071618459630","type":2,"comments":"检测扣费","beforeMoney":19571.64},{"id":60351,"createTime":"2017-03-07 14:13:55","currentMoney":19571.64,"title":"兔兔","status":1,"money":1.3,"orderNum":"1703071413479007","type":2,"comments":"检测扣费","beforeMoney":19572.94},{"id":60322,"createTime":"2017-03-07 14:06:59","currentMoney":19572.94,"title":"兔兔","status":1,"money":1.3,"orderNum":"1703071406579642","type":2,"comments":"检测扣费","beforeMoney":19574.24},{"id":60209,"createTime":"2017-03-07 13:35:17","currentMoney":19574.24,"title":"支付宝支付","status":1,"money":0.01,"orderNum":"1703071335175131","type":0,"comments":"APP","beforeMoney":19574.23},{"id":60198,"createTime":"2017-03-07 13:31:35","currentMoney":null,"title":"支付宝支付","status":4,"money":0.1,"orderNum":"1703071331354931","type":0,"comments":"APP","beforeMoney":null},{"id":59807,"createTime":"2017-03-07 11:57:10","currentMoney":null,"title":"支付宝支付","status":4,"money":0.1,"orderNum":"1703071157106400","type":0,"comments":"APP","beforeMoney":null}]
     * countOfCurrentPage : 10
     * currentPage : 1
     * totalCount : 71
     * totalPage : 8
     */
    var data: DataBean? = null
    var countOfCurrentPage: Int = 0
    var currentPage: Int = 0
    var totalCount: Int = 0
    var totalPage: Int = 0
    var pageResults: List<PageResultsBean>? = null

    class DataBean {
        /**
         * allTypes : {"0":"充值","1":"加款","2":"扣款","3":"提现","4":"付款"}
         * allStatuss : {"1":"成功","2":"失败","3":"冻结","4":"处理中","5":"作废"}
         */

        var allTypes: AllTypesBean? = null
        var allStatuss: AllStatussBean? = null

        class AllTypesBean {
            /**
             * 0 : 充值
             * 1 : 加款
             * 2 : 扣款
             * 3 : 提现
             * 4 : 付款
             */

            @SerializedName("0")
            var `_$0`: String? = null
            @SerializedName("1")
            var `_$1`: String? = null
            @SerializedName("2")
            var `_$2`: String? = null
            @SerializedName("3")
            var `_$3`: String? = null
            @SerializedName("4")
            var `_$4`: String? = null
        }

        class AllStatussBean {
            /**
             * 1 : 成功
             * 2 : 失败
             * 3 : 冻结
             * 4 : 处理中
             * 5 : 作废
             */

            @SerializedName("1")
            var `_$1`: String? = null
            @SerializedName("2")
            var `_$2`: String? = null
            @SerializedName("3")
            var `_$3`: String? = null
            @SerializedName("4")
            var `_$4`: String? = null
            @SerializedName("5")
            var `_$5`: String? = null
        }
    }

    class PageResultsBean {
        /**
         * id : 71653
         * createTime : 2017-03-09 16:36:01
         * currentMoney : null
         * title : 微信充值
         * status : 4
         * money : 0.1
         * orderNum : 1703091636019475
         * type : 0
         * comments : 微信充值
         * beforeMoney : null
         */

        var id: Int = 0
        var createTime: String? = null
        var currentMoney: String? = null
        var title: String? = null
        var status: Int = 0
        var money: Double = 0.toDouble()
        var orderNum: String? = null
        var type: Int = 0
        var comments: String? = null
        var beforeMoney: String? = null
    }
}
