package com.lanxiang.cheyy

import android.arch.lifecycle.MutableLiveData
import com.lanxiang.mvvm.http.State
import com.lanxiang.mvvm.http.response.BaseResponse
import com.lanxiang.mvvm.utlis.SchedulerUtils

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-15:52
 *
 * @desc:主数据仓库
 */
class MainRepository(loadState:MutableLiveData<State>) : ApiRepository() {
   private var loadState = MutableLiveData<State>()
    init {
        this.loadState = loadState
    }
    fun getMianData(liveData: MutableLiveData<BaseResponse<MainBean>>, map: Map<String, String>) {
        apiService.getMainData(map)
            //减少线程切换代码
            .compose(SchedulerUtils.ioAndMainScheduler())
            .subscribe (BaseObserver(liveData,loadState,this))

    }
}