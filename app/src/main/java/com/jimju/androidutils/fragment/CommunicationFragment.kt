package com.jimju.androidutils.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jimju.androidutils.R
import com.jimju.androidutils.adapter.BaseRecyclerAdapter


/**
 * A simple [Fragment] subclass.
 */
class CommunicationFragment : Fragment(),BaseRecyclerAdapter.OnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_common, container, false)
    }

    companion object {
        fun newInstance(): CommunicationFragment {
            val fragment = CommunicationFragment()

            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onItemClick(position: Int) {

    }


}
