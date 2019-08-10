package com.lanxiang.mvvm.http

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-11:40
 *
 * @desc:
 */
object ErrorCode {
    /**
     * 服务器错误，如500等5XX HttpException
     */
    const val SERVICE_ERROR = 1002
    /**
     * 非法参数错误 IllegalArgumentException
     */
    const val PARAMETER_ERROR = 1003
    /**
     * 解析异常
     */
    const val ANALYSIS_ERROR = 1004
    /**
     * 网络超时
     */
    const val NET_TIME_OUT_ERROR = 1005
    /**
     * 网络无法连接
     */
    const val NET_NOT_ERROR = 1006
    /**
     * 未知错误
     */
    const val UNKOWN_ERROR = 1007
}