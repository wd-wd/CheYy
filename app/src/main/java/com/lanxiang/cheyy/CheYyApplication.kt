package com.lanxiang.cheyy

import android.content.Context
import com.lanxiang.mvvm.base.BaseApplication
import kotlin.properties.Delegates

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/9-11:18
 *
 * @desc:app初始化
 */
class CheYyApplication: BaseApplication() {
    companion object{
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}