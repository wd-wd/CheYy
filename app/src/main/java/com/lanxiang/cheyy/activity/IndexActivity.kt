package com.lanxiang.cheyy.activity

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.lanxiang.cheyy.R
import com.lanxiang.mvvm.base.BaseActivity
import kotlinx.android.synthetic.main.index_activity.*
import java.util.*

class IndexActivity: BaseActivity() {
    private lateinit var mTabLayout: TabLayout
    private lateinit var mFragmensts: Array<Fragment?>
    override fun reTryData() {
    }

    override fun layoutId(): Int =
        R.layout.index_activity

    override fun initView() {
        mFragmensts = DataGenerator.getFragments("TabLayout Tab")
        initTabLayout()

    }

    /**
     * 初始化tab
     */
    private fun initTabLayout() {
        mTabLayout=bottom_tab_layout
        mTabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                onTabItemSelected(tab!!.getPosition())
                for (i in 0 until mTabLayout.tabCount) {
                    val view = mTabLayout.getTabAt(i)!!.customView
                    val icon = view!!.findViewById(R.id.tab_content_image) as ImageView
                    val text = view.findViewById(R.id.tab_content_text) as TextView
                    if (i == tab!!.getPosition()) {
                        icon.setImageResource(DataGenerator.mTabResPressed[i])
                        text.setTextColor(resources.getColor(android.R.color.black))
                    } else {
                        icon.setImageResource(DataGenerator.mTabRes[i])
                        text.setTextColor(resources.getColor(android.R.color.darker_gray))
                    }
                }
            }
        })
        for (i in 0..3) {
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(DataGenerator.getTabView(this, i)))
        }
    }

    private fun onTabItemSelected(position: Int) {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = mFragmensts?.get(0)
            1 -> fragment = mFragmensts?.get(1)

            2 -> fragment = mFragmensts?.get(2)
            3 -> fragment = mFragmensts?.get(3)
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.home_container, fragment).commit()
        }
    }

    override fun initData() {
    }

}