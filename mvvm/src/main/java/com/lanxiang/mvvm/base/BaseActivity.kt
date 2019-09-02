package com.lanxiang.mvvm.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.lanxiang.common.view.MultipleStatusView
import com.lanxiang.mvvm.utlis.DialogUtils

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-13:53
 *
 * @desc:activity基类
 */
abstract class BaseActivity : AppCompatActivity() {
    protected var loadStateView: MultipleStatusView? = null
    protected val dialogUtils:DialogUtils = DialogUtils()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
        initData()
        reTryData()
        initListener()
    }

    private fun initListener() {
        loadStateView?.setOnClickListener(reTryDataListener)
    }

    open var reTryDataListener: View.OnClickListener = View.OnClickListener {
        reTryData()
    }

    abstract fun layoutId(): Int

    abstract fun initView()

    abstract fun initData()

    abstract fun reTryData()

}
