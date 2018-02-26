package com.jimju.androidutils.adapter;

import android.content.Context;
import android.widget.TextView;

import com.jimju.androidutils.R;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/2/6.
 */

public class SimpleStringRecyclerAdapter extends BaseRecyclerAdapter<String> {



    public SimpleStringRecyclerAdapter(List<String> mCollection, Context mCxt, int layoutId) {
        super(mCollection, mCxt, layoutId);
    }

    public SimpleStringRecyclerAdapter(String[] strings, Context mCxt, int layoutId) {
        this(Arrays.asList(strings), mCxt, layoutId);
    }

    @Override
    public void convert(RecyclerHolder holder, String item) {
        TextView textView = holder.getView(R.id.text);
        if (textView != null)
            textView.setText(item);
            textView.setText(item);
    }
}
