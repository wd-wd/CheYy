package com.lanxiang.cheyy

import com.lanxiang.mvvm.base.BaseRepository
import com.lanxiang.mvvm.common.Constant

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-15:53
 *
 * @desc:服务器数据api仓库
 */
open class ApiRepository : BaseRepository() {
    protected val apiService by lazy {
        RetrofitFactory.instance.getRetrofit(Constant.SERVER_ADDRESS).create(ApiService::class.java)
    }
}