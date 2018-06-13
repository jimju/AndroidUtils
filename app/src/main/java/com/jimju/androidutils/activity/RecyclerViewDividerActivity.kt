package com.jimju.androidutils.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.jimju.androidutils.R
import com.jimju.androidutils.adapter.ApplicationsAdapter
import com.jimju.androidutils.recyclerview.GridItemDecoration
import com.jimju.androidutils.recyclerview.SimpleItemDecoration
import com.jimju.androidutils.utils.AppTools
import kotlinx.android.synthetic.main.activity_divider.*

class RecyclerViewDividerActivity : AppCompatActivity() {
    var mDecoration:RecyclerView.ItemDecoration ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_divider)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = ApplicationsAdapter(this)
        mDecoration = SimpleItemDecoration(this,LinearLayoutManager.VERTICAL)
        recyclerview.addItemDecoration(mDecoration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.divider_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        recyclerview.removeItemDecoration(mDecoration)
        when(item!!.itemId){
            R.id.rv_grid -> {
                recyclerview.layoutManager = GridLayoutManager(this, 3)
                mDecoration = GridItemDecoration(this)
            }
            R.id.rv_list ->{
                recyclerview.layoutManager = LinearLayoutManager(this)
                mDecoration = SimpleItemDecoration(this,LinearLayoutManager.VERTICAL)
            }
        }
        recyclerview.addItemDecoration(mDecoration)
        return false
    }
}
