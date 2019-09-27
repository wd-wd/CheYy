package com.lanxiang.cheyy.activity

import android.content.Context
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.lanxiang.cheyy.R
import com.lanxiang.cheyy.fragment.AttentionFragment
import com.lanxiang.cheyy.fragment.DiscoveryFragment
import com.lanxiang.cheyy.fragment.HomeFragment
import com.lanxiang.cheyy.fragment.ProfileFragment


object DataGenerator {

    val mTabRes = intArrayOf(
        R.drawable.tab_home_selector,
        R.drawable.tab_discovery_selector,
        R.drawable.tab_attention_selector,
        R.drawable.tab_profile_selector
    )
    val mTabResPressed = intArrayOf(
        R.drawable.ic_tab_strip_icon_feed_selected,
        R.drawable.ic_tab_strip_icon_category_selected,
        R.drawable.ic_tab_strip_icon_pgc_selected,
        R.drawable.ic_tab_strip_icon_profile_selected
    )
    val mTabTitle = arrayOf("首页", "发现", "关注", "我的")

    fun getFragments(from: String): Array<Fragment?> {
        val fragments = arrayOfNulls<Fragment>(4)
        fragments[0] = HomeFragment.newInstance(from)
        fragments[1] = DiscoveryFragment.newInstance(from)
        fragments[2] = AttentionFragment.newInstance(from)
        fragments[3] = ProfileFragment.newInstance(from)
        return fragments
    }

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    fun getTabView(context: Context, position: Int): View {
        val view = LayoutInflater.from(context).inflate(R.layout.home_tab_content, null)
        val tabIcon = view.findViewById<View>(R.id.tab_content_image) as ImageView
        tabIcon.setImageResource(mTabRes[position])
        val tabText = view.findViewById<View>(R.id.tab_content_text) as TextView
        tabText.text = mTabTitle[position]
        return view
    }
}
