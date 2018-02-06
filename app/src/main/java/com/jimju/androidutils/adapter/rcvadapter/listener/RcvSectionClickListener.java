package com.jimju.androidutils.adapter.rcvadapter.listener;


import com.jimju.androidutils.adapter.rcvadapter.holder.RcvHolder;

/**
 * Created by LWK
 * TODO
 * 2017/4/27
 */

public interface RcvSectionClickListener<S>
{
    void onSectionClicked(RcvHolder holder, S section, int position);
}
