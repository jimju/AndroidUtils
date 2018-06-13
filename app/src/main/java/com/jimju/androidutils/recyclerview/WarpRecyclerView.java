package com.jimju.androidutils.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HeaderViewListAdapter;

import java.util.ArrayList;

/**
 * Created by jimju on 2018/2/27.
 */

public class WarpRecyclerView extends RecyclerView {
    private Adapter mAdapter;
    private ArrayList<View> mHeaderViewInfos = new ArrayList<>();
    private ArrayList<View> mFooterViewInfos = new ArrayList<>();
    public WarpRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void addHeaderView(View v){
        if (!mHeaderViewInfos.isEmpty())
            mHeaderViewInfos.clear();
        mHeaderViewInfos.add(v);
        if (mAdapter != null){
            if (!(mAdapter instanceof HeaderViewRecyclearAdapter)){
                mAdapter = new HeaderViewRecyclearAdapter(mHeaderViewInfos,mFooterViewInfos,mAdapter);
            }
        }
    }

    public void addFooterView(View v){
        if (!mFooterViewInfos.isEmpty())
            mFooterViewInfos.clear();
        mFooterViewInfos.add(v);
        if (mAdapter != null)
            if (!(mAdapter instanceof HeaderViewRecyclearAdapter)){
                mAdapter = new HeaderViewRecyclearAdapter(mHeaderViewInfos,mFooterViewInfos,mAdapter);
            }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (mHeaderViewInfos.size() > 0 || mFooterViewInfos.size() > 0){
            mAdapter = new HeaderViewRecyclearAdapter(mHeaderViewInfos,mFooterViewInfos,adapter);
        }else {
            mAdapter = adapter;
        }
        super.setAdapter(mAdapter);
    }
}
