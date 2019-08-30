package com.lanxiang.cheyy

import android.arch.lifecycle.MutableLiveData
import android.net.NetworkInfo
import android.util.Log
import android.widget.Toast
import com.lanxiang.mvvm.base.BaseRepository
import com.lanxiang.mvvm.common.Constant
import com.lanxiang.mvvm.http.State
import com.lanxiang.mvvm.http.StateType
import com.lanxiang.mvvm.http.exception.HandleException
import com.lanxiang.mvvm.http.response.BaseResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/6-17:59
 *
 * @desc:封装 观察者Obaserver -> 请求基础状态分发 -> 若 成功 直接返回到 view
 */
 class BaseObserver<T : BaseResponse<*>>(
    val liveData: MutableLiveData<T>,
    val loadState: MutableLiveData<State>,
    val repository: BaseRepository
) : Observer<T> {
    override fun onError(e: Throwable) {
        Toast.makeText(CheYyApplication.context,HandleException.ExceptionHandle(e),Toast.LENGTH_LONG).show()
        HandleException.ExceptionHandle(e)
        loadState.postValue(State(StateType.ERROR))
        Log.d("onError",e.message)
    }

    override fun onComplete() {
        //与error方法不会同时执行
    }

    override fun onSubscribe(d: Disposable) {
        repository.addSubscribe(d)
    }

    override fun onNext(response: T) {
        Log.d("onNext","onNext")
        when (response.code) {
            Constant.SUCCESS -> {
                if (response.data is List<*>) {
                    if ((response.data as List<*>).isEmpty()) {
                        //列表数据是空时返回空数据view
                        loadState.postValue(State(StateType.EMPTY))
                    }
                }
                // 加载成功
                loadState.postValue(State(StateType.SUCCESS))

                // 正常返回
                liveData.postValue(response)
            }
        }
    }
}