package com.lanxiang.mvvm.http.response

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/5-16:31
 *
 * @desc:数据响应基类 data形参具体类型
 */
open class BaseResponse<T>(var code:Int,var msg:String,var data:T)