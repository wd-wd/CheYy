package com.lanxiang.mvvm.base

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.lanxiang.mvvm.http.State
import com.lanxiang.mvvm.http.StateType
import com.lanxiang.mvvm.utlis.Util

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-14:11
 *
 * @desc:viewModel的activity基类
 */
abstract class LifecycleActivity<T : BaseViewModel<*>> : BaseActivity() {
    //初始化viewModel
    protected lateinit var viewModel: T

    override fun initView() {
        viewModel = ViewModelProviders.of(this).get(Util.getClass(this))
        viewModel.loadState.observe(this, observer)
        // 设置  view 的 observer
        dataObserver()
    }

    /**
     * 数据变化观察者
     */
    abstract fun dataObserver()

    private val observer by lazy {
        Observer<State> { state: State? ->
            state?.let {
                when (state.code) {
                    //成功显示内容
                    StateType.SUCCESS -> showSuccessView()
                    StateType.EMPTY -> showEmptyView()
                    StateType.ERROR -> showErrorView()
                }
            }
        }
    }

    /**
     * 加载中
     */
   abstract fun showLoadingView()


    /**
     * 加载数据成功
     */
    open fun showSuccessView(){
        loadStateView?.showContent()
    }



    /**
     * 数据为空界面
     */
    abstract fun showEmptyView()


    /**
     * 加载失败界面
     */
    abstract fun showErrorView()
}