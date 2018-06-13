package com.jimju.androidutils.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jimju.androidutils.R
import kotlinx.android.synthetic.main.activity_app_detail.*
import kotlinx.android.synthetic.main.activity_metrial.*

class AppDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_detail)
        var name = intent.getStringExtra("name")
        setSupportActionBar(toolbar)
        toolbar.setTitle(name)
        toolbar.setNavigationOnClickListener { finish() }
        text.text = name

    }
}
