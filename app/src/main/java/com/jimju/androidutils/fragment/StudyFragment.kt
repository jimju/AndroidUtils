package com.jimju.androidutils.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jimju.androidutils.R
import com.jimju.androidutils.activity.FileActivity
import com.jimju.androidutils.adapter.BaseRecyclerAdapter
import com.jimju.androidutils.adapter.SimpleStringRecyclerAdapter

/**
 * A simple [Fragment] subclass.
 */
class StudyFragment : Fragment(), BaseRecyclerAdapter.OnItemClickListener {
    override fun onItemClick(position: Int) {
        when(position){
            0 -> startActivity(Intent(activity, FileActivity::class.java))
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_common, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        var items = arrayOf("系统文件选择功能")
        var adapter = SimpleStringRecyclerAdapter(items, activity, R.layout.item_simple_text)
        recyclerview.adapter = adapter
        adapter.setOnItemClickLister(this)
    }

    companion object {
        fun newInstance(): StudyFragment {
            val fragment = StudyFragment()
            return fragment
        }
    }

}