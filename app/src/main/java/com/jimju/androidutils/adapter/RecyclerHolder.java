package com.jimju.androidutils.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jim_huang on 2016/8/5.
 */
public class RecyclerHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> mViews;  //View 的集合
    private final int MAX_SIZE = 8; //暂定最大值为8，根据实际需要设定该值
    public RecyclerHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<>(MAX_SIZE);
    }

    /**
     * 通过控件 的Id获取对应的空间，如果没有则加入到SparseArray中
     */
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            view = itemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     */
    public RecyclerHolder setText(int viewId,String text){
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }
    /**
     * 为ImageView设置字符串
     */
    public RecyclerHolder setImageResouse(int viewId,int resId){
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }



}
