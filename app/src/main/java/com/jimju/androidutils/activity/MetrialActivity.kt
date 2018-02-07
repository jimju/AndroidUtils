package com.jimju.androidutils.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jimju.androidutils.R
import kotlinx.android.synthetic.main.activity_main.*

class MetrialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metrial)
        setSupportActionBar(toolbar)
        toolbar.title = "MetrialDesign"

    }
}
