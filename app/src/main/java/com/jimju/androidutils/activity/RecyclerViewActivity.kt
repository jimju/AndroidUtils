package com.jimju.androidutils.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jimju.androidutils.R
import com.jimju.androidutils.adapter.BaseRecyclerAdapter
import com.jimju.androidutils.adapter.SimpleStringRecyclerAdapter
import kotlinx.android.synthetic.main.activity_recycler_view.*


class RecyclerViewActivity : AppCompatActivity(), BaseRecyclerAdapter.OnItemClickListener {
    override fun onItemClick(position: Int) {
        var intent:Intent = Intent()
        when (position){
            0 -> intent.setClass(this, RecyclerViewDividerActivity::class.java)
            1 -> intent.setClass(this, RecyclerViewHeaderActivity::class.java)
            else -> intent.setClass(this, RecyclerViewDividerActivity::class.java)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        //setTitle要写在setSupportActionbar前面
//        toolbar.setTitle("RecyclerView")
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
        var items:Array<String> =  arrayOf("Divider","HeaderAndFooter","Undefine","Undefine","Undefine")
        recyclerview.layoutManager = LinearLayoutManager(this)
        var adapter = SimpleStringRecyclerAdapter(items,this,R.layout.item_simple_text)
        adapter.setOnItemClickLister(this)
        recyclerview.adapter = adapter
    }
}
