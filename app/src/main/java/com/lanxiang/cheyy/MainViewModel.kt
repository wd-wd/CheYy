package com.lanxiang.cheyy

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.lanxiang.mvvm.base.BaseViewModel
import com.lanxiang.mvvm.http.response.BaseResponse
import org.jetbrains.annotations.NotNull

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-15:48
 *
 * @desc: 主activity的
 */
class MainViewModel(application: Application) : BaseViewModel<MainRepository>(application) {
    var liveData = MutableLiveData<BaseResponse<MainBean>>()
        internal set
    fun getMainData(map: Map<String,String>){
        repository.getMianData(liveData,map)
    }
}