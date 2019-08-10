package com.lanxiang.mvvm.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/6-17:56
 *
 * @desc: 控制所有 订阅事件防止内存泄露
 */
abstract class BaseRepository {
    private val mCompositeDisposable by lazy { CompositeDisposable() }

    fun addSubscribe(disposable: Disposable) = mCompositeDisposable.add(disposable)

    fun unSubscribe() = mCompositeDisposable.dispose()
}