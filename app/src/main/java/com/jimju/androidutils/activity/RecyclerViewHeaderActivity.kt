package com.jimju.androidutils.activity

import android.app.ActionBar
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.jimju.androidutils.R
import com.jimju.androidutils.adapter.ApplicationsAdapter
import kotlinx.android.synthetic.main.activity_recycler_view_header.*

class RecyclerViewHeaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_header)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
        var params = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT)
        var t1 = TextView(this)
        t1.text = "Hello Header"
        t1.layoutParams = params
        var t2 = TextView(this)
        t2.text = "Hello Footer"
        t2.layoutParams = params

        var t3 = TextView(this)
        t3.text = "Hello Footer11"
        t3.setBackgroundColor(Color.GREEN)
        t3.layoutParams = params

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addHeaderView(t1)
        recyclerview.addFooterView(t2)
        var adapter = ApplicationsAdapter(this)
        recyclerview.adapter = adapter
        adapter.setOnItemClickLister{ position:Int -> Toast.makeText(this,"ItemPosition" + position,Toast.LENGTH_SHORT).show()}
    }
}
