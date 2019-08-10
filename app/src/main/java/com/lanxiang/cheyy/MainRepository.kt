package com.lanxiang.cheyy

import android.arch.lifecycle.MutableLiveData
import com.lanxiang.mvvm.base.BaseObserver
import com.lanxiang.mvvm.base.BaseRepository
import com.lanxiang.mvvm.http.State
import com.lanxiang.mvvm.http.response.BaseResponse
import com.lanxiang.mvvm.utlis.SchedulerUtils
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-15:52
 *
 * @desc:主数据仓库
 */
class MainRepository(internal var loadState: MutableLiveData<State>) : ApiRepository() {
    fun getMianData(liveData: MutableLiveData<BaseResponse<MainBean>>, map: Map<String, String>) {
        apiService.getMainData(map)
            //减少线程切换代码
            .compose(SchedulerUtils.ioAndMianScheduler())
            .subscribe { BaseObserver(liveData,loadState,this)}

    }
}