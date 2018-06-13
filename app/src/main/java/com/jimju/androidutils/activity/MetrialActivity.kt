package com.jimju.androidutils.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jimju.androidutils.R
import com.jimju.androidutils.adapter.SimpleStringRecyclerAdapter
import kotlinx.android.synthetic.main.activity_metrial.*
import android.R.id.toggle
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.res.Configuration
import android.os.Build
import android.os.PersistableBundle
import android.support.annotation.RequiresApi
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.TableLayout
import android.widget.Toast
import com.jimju.androidutils.BuildConfig
import com.jimju.androidutils.R.id.toolbar
import com.jimju.androidutils.adapter.ApplicationsAdapter
import com.jimju.androidutils.adapter.BaseRecyclerAdapter
import com.jimju.androidutils.utils.AppTools


class MetrialActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, BaseRecyclerAdapter.OnItemClickListener {


    var toggle: ActionBarDrawerToggle? = null;
    var apps: List<ApplicationInfo>? = null;

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.back) {
            finish()
            return true
        }
        if (item.itemId == R.id.drawer_tablayout) {
            startActivity(Intent(MetrialActivity@this,MetrialTabLayoutActivity::class.java))
            return true
        }
        drawerlayout.closeDrawers()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metrial)
        toolbar.setTitle("MetrialDesign")
        setSupportActionBar(toolbar)
//        toolbar.setNavigationOnClickListener { this.onBackPressed() }
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbarLayout.setTitle("MetrialDesign")
        navigationView.setNavigationItemSelectedListener(this)
        toggle = ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        toggle!!.syncState()
        drawerlayout.addDrawerListener(toggle!!)

        apps = AppTools.getApps(this)

        var adapter: ApplicationsAdapter? = ApplicationsAdapter(apps, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
        adapter!!.setOnItemClickLister(this)

        floatButton.setOnClickListener { Snackbar.make(floatButton, "Snackbar is showing!", Snackbar.LENGTH_SHORT).setAction("Toast", View.OnClickListener {
            Toast.makeText(MetrialActivity@this,"Toast is showing!", Toast.LENGTH_SHORT).show()
        }).show() }
//        adapter.setOnItemClickLister(this)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onItemClick(position: Int) {
        var intent = Intent(this, AppDetailActivity::class.java)
        intent.putExtra("name", apps!!.get(position).packageName)
        var comp: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(floatButton, "fab"))
        startActivity(intent, comp.toBundle())
    }


}
