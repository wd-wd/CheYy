package com.lanxiang.mvvm.http.exception

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-12:21
 *
 * @desc: 服务器异常
 */
class ApiException : RuntimeException {

    private var code: Int? = null


    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }

    constructor(message: String) : super(Throwable(message))
}