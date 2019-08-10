package com.lanxiang.mvvm.http


import com.lanxiang.mvvm.common.LogUtil
import okhttp3.logging.HttpLoggingInterceptor

class HttpLogger : HttpLoggingInterceptor.Logger {

    private val mMessage = StringBuffer()

    override fun log(message: String?) {
        var message = message
        // 请求或者响应开始
        if (message!!.startsWith("--> POST")) {
            mMessage.setLength(0)
        }
        // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
        if (message.startsWith("{") && message.endsWith("}") || message.startsWith("[") && message.endsWith("]")) {
            //message = JsonUtil.formatJson(JsonUtil.decodeUnicode(message));
            message = JsonUtil.stringToJSON(message)
        }
        //mMessage.append(message.concat("\n"));
        if (message != null && message.length > 0 && message.length < 1024 * 10) {
            mMessage.append(message).append("\n")
            //Log.e("TAG", "message: "+message+"\n" );
        } else {
            //Log.e("TAG", "message:为空 "+mMessage.length() );
        }

        // 响应结束，打印整条日志
        if (message!!.startsWith("<-- END HTTP")) {
            LogUtil.d(mMessage.toString())
        }
    }
}