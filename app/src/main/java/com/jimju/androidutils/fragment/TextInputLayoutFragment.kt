package com.jimju.androidutils.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jimju.androidutils.R
import kotlinx.android.synthetic.main.fragment_text_input_layout.*


/**
 * A simple [Fragment] subclass.
 */
class TextInputLayoutFragment : Fragment(), TextWatcher {
    override fun afterTextChanged(p0: Editable?) {

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if (p0!!.length > textinput1.counterMaxLength){
            textinput1.error = "超出限定字数了...";
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_input_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edittext1.addTextChangedListener(this)
    }

    companion object {

        fun newInstance(): TextInputLayoutFragment {
            val fragment = TextInputLayoutFragment()

            return fragment
        }
    }

}// Required empty public constructor
