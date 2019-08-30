package com.lanxiang.mvvm.http.exception

import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.lanxiang.mvvm.http.ErrorCode
import com.orhanobut.logger.Logger
import org.json.JSONException
import retrofit2.HttpException
import java.net.*
import java.text.ParseException

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-12:21
 *
 * @desc: 异常处理
 */
class HandleException {
    companion object {
        var errorMsg = "请求失败,请稍后重试"
        var errorCode = ErrorCode.UNKOWN_ERROR

        fun ExceptionHandle(e: Throwable?): String {
            e!!.printStackTrace()
            //网络超时
            if (e is SocketTimeoutException) {
                Logger.e("TAG", "网络连接超时: " + e.message)
                errorMsg = "网络连接超时"+e.message
                errorCode = ErrorCode.NET_TIME_OUT_ERROR
            }
            //网络连接异常
            else if (e is ConnectException
                ||e is SocketException
                || e is HttpException
                || e is UnknownHostException||e is NoRouteToHostException
            ){
                Logger.e("TAG", "网络连接异常: " + e.message)
                errorMsg = "网络连接异常"+e.message
                errorCode = ErrorCode.NET_NOT_ERROR
            }
            //解析错误
            else if (e is JsonParseException
                || e is JSONException
                || e is ParseException
                ||e is JsonSyntaxException){
                Logger.e("TAG", "数据解析异常: " + e.message)
                errorMsg = "数据解析异常"+e.message
                errorCode = ErrorCode.NET_NOT_ERROR
            }
            //服务器错误
            else if (e is ApiException){
                Logger.e("TAG", "服务器错误: " + e.message)
                errorMsg = "服务器错误"+e.message
                errorCode = ErrorCode.SERVICE_ERROR
            }else {//未知错误
                try {
                    Logger.e("TAG", "错误: " + e.message)
                } catch (e1: Exception) {
                    Logger.e("TAG", "未知错误Debug调试 ")
                }

                errorMsg = "未知错误，可能抛锚了吧~"
                errorCode = ErrorCode.UNKOWN_ERROR
            }
            return errorMsg
        }
    }

}