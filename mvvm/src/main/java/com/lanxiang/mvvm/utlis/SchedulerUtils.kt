package com.lanxiang.mvvm.utlis

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-17:10
 *
 * @desc:线程控制器工具类
 */
object SchedulerUtils {
    fun <T> ioAndMianScheduler(): ObservableTransformer<T, T> = ObservableTransformer { it ->
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}