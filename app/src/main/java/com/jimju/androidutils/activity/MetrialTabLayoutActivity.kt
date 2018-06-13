package com.jimju.androidutils.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.jimju.androidutils.R
import com.jimju.androidutils.fragment.SimpleImageFragment
import com.jimju.androidutils.fragment.TextInputLayoutFragment
import kotlinx.android.synthetic.main.activity_metrial_tab_layout.*

/**
 * app:tabIndicatorColor ：指示条的颜色
app:tabIndicatorHeight ：指示条的高度
app:tabSelectedTextColor ： tab被选中时的字体颜色
app:tabTextColor ： tab未被选中时的字体颜色
app:tabMode="scrollable" ： 默认是fixed：固定的，标签很多时候会被挤压，不能滑动。

 */

class MetrialTabLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metrial_tab_layout)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
        viewpager.adapter = MyPagerAdapter(supportFragmentManager)
        tablayout.setupWithViewPager(viewpager)
    }

    class MyPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

        var fragments = arrayOf(TextInputLayoutFragment.newInstance(),SimpleImageFragment.newInstance(R.mipmap.b1),SimpleImageFragment.newInstance(R.mipmap.b2),SimpleImageFragment.newInstance(R.mipmap.b3),SimpleImageFragment.newInstance(R.mipmap.b1))
        var titles = arrayOf("Text","Image0","Image1","Image2","Image3")
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

    }
}
