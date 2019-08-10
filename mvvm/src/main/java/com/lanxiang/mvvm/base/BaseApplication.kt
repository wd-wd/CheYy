package com.lanxiang.mvvm.base

import android.app.Application
import com.lanxiang.mvvm.common.Preference

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/9-11:14
 *
 * @desc:app初始化基类
 */
abstract class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 初始化 SharedPreference
        Preference.setContext(applicationContext)
    }
}
