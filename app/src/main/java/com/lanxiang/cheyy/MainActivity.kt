package com.lanxiang.cheyy

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lanxiang.mvvm.base.LifecycleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : LifecycleActivity<MainViewModel>() {
    override fun showLoadingView() {
        loadStateView?.showLoading()
    }


    override fun showEmptyView() {

    }

    override fun showErrorView() {

    }

    override fun layoutId(): Int = R.layout.activity_main
    override fun initView() {
        super.initView()
        var map = HashMap<String, String>()
        map["page"] = "1"
        tv.setOnClickListener {
            showLoadingView()
            viewModel.getMainData(map) }
    }

    override fun dataObserver() {
        showSuccessView()
        viewModel.liveData.observe(this, Observer {

        })
    }

    override fun reTryData() {

    }


}
