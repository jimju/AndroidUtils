package com.jimju.androidutils.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jimju.androidutils.MainActivity

import com.jimju.androidutils.R
import com.jimju.androidutils.activity.MetrialActivity
import com.jimju.androidutils.activity.RecyclerViewActivity
import com.jimju.androidutils.adapter.BaseRecyclerAdapter
import com.jimju.androidutils.adapter.SimpleStringRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_main_common.*


/**
 * A simple [Fragment] subclass.
 * Use the [WidgetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WidgetFragment : Fragment(), BaseRecyclerAdapter.OnItemClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_common, container, false)
    }


    companion object {

        fun newInstance(): WidgetFragment {
            val fragment = WidgetFragment()

            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var items = arrayListOf("Material", "RecyclerView")
        var adapter: SimpleStringRecyclerAdapter = SimpleStringRecyclerAdapter(items, activity, R.layout.item_simple_text)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = adapter
        adapter.setOnItemClickLister(this)
    }

    override fun onItemClick(position: Int) {
        var intent:Intent = Intent(activity,MetrialActivity::class.java)
        when(position){
            0 -> intent =  Intent(activity,MetrialActivity::class.java)
            1 -> intent = Intent(activity,RecyclerViewActivity::class.java)
        }

        startActivity(intent)
    }

}
