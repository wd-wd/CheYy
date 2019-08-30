package com.lanxiang.cheyy

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lanxiang.mvvm.base.LifecycleActivity
import kotlinx.android.synthetic.main.activity_main.*
/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-13:53
 *
 * @desc:测试
 */
class MainActivity : LifecycleActivity<MainViewModel>() {
    var map: HashMap<String, String>? = null
    override fun layoutId(): Int = R.layout.activity_main
    override fun initView() {
        super.initView()
        loadStateView=multipleStatusView
        map = HashMap<String, String>()
        map!!["page"] = "1"
        tv.setOnClickListener {
           reTryData()
        }
    }
    override fun initData() {

    }

    override fun dataObserver() {
        viewModel.liveData.observe(this, Observer {
        })
    }

    override fun reTryData() {
        showLoadingView()
        viewModel.getMainData(map!!)
    }


}
