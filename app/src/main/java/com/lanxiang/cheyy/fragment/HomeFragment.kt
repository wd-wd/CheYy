package com.lanxiang.cheyy.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lanxiang.cheyy.R


class HomeFragment : Fragment() {
    private var mFrom: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mFrom = arguments!!.getString("from")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.home_fragment_layout, null)
        val textView = view.findViewById<View>(R.id.title_from) as TextView
        val content = view.findViewById<View>(R.id.fragment_content) as TextView
        textView.text = mFrom
        content.text = "Homefragment"
        return view
    }

    companion object {
        fun newInstance(from: String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            bundle.putString("from", from)
            fragment.arguments = bundle
            return fragment
        }
    }
}
