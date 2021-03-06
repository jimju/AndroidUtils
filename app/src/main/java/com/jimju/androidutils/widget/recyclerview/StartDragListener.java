package com.jimju.androidutils.recyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * Created by jimju on 2018/3/1.
 */

public interface StartDragListener {
    /**
     * 该接口用于需要主动回调拖拽效果的
     * @param viewHolder
     */
    public void onStartDrag(RecyclerView.ViewHolder viewHolder);
}
