package com.jimju.androidutils

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v4.view.ViewPager.OnPageChangeListener
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.MenuItem
import android.view.MotionEvent
import com.jimju.androidutils.R.id.toolbar
import com.jimju.androidutils.fragment.CommunicationFragment
import com.jimju.androidutils.fragment.FunctionFragment
import com.jimju.androidutils.fragment.WidgetFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, OnPageChangeListener {

    var menuItem: MenuItem? = null

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_widget -> viewpager.currentItem = 0
            R.id.navigation_function -> viewpager.currentItem = 1
            R.id.navigation_communication -> viewpager.currentItem = 2
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(Color.WHITE)
        navigation.setOnNavigationItemSelectedListener(this)
        viewpager.adapter = MyViewPagerAdapter(supportFragmentManager)
        viewpager.addOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        if (menuItem == null)
            navigation.menu.getItem(0).isChecked = false;
        menuItem?.isChecked = false;
        menuItem = navigation.menu.getItem(position);
        menuItem?.isChecked = true
    }


    class MyViewPagerAdapter : FragmentStatePagerAdapter {
        var fragments: Array<Fragment> = arrayOf(WidgetFragment.newInstance(), FunctionFragment.newInstance(), CommunicationFragment.newInstance())

        constructor(fm: FragmentManager) : super(fm) {

        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

    }
}
