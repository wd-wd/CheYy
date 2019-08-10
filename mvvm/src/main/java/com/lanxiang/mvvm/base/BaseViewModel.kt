package com.lanxiang.mvvm.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.lanxiang.mvvm.http.State
import com.lanxiang.mvvm.utlis.Util

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-14:14
 *
 * @desc:viewModel的基类继承AndroidViewModel 注意使用时super要带
 */
open class BaseViewModel<T : BaseRepository>(application: Application) : AndroidViewModel(application) {
    //初始化加载状态的livedata
    val loadState by lazy { MutableLiveData<State>() }
    // 通过反射注入 mRepository
    val repository: T by lazy {
        // 获取 对应 Repository 实例 (有参构造函数)
        (Util.getClass<T>(this))
            //获取构造函数的构造器, 传入参数 Class
            .getDeclaredConstructor(MutableLiveData::class.java)
            // 传入参数 (后面子类 repository 会用到 )
            .newInstance(loadState)
    }

    /**
     * 在activity或fragment销毁是自动调用，现在本方法中统一取消全部订阅防止内存溢出
     */
    override fun onCleared() {
        super.onCleared()
        repository.unSubscribe()
    }

}