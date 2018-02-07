package com.jimju.androidutils.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jimju.androidutils.R
import kotlinx.android.synthetic.main.activity_main.*
import com.jimju.androidutils.R.id.toolbar



class MetrialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metrial)
        toolbar.setTitle("MetrialDesign")
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { this.onBackPressed() }
    }
}
