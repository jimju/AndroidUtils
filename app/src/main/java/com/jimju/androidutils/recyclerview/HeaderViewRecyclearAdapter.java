package com.jimju.androidutils.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by jimju on 2018/2/27.
 */

public class HeaderViewRecyclearAdapter extends RecyclerView.Adapter {
    private RecyclerView.Adapter mAdapter;
    ArrayList<View> mHeaderViewInfos;
    ArrayList<View> mFooterViewInfos;

    public HeaderViewRecyclearAdapter(ArrayList<View> mHeaderViewInfos, ArrayList<View> mFooterViewInfos, RecyclerView.Adapter adapter) {
        mAdapter = adapter;
        this.mHeaderViewInfos = mHeaderViewInfos;
        this.mFooterViewInfos = mFooterViewInfos;
        if (mFooterViewInfos == null)
            mFooterViewInfos = new ArrayList<>();
        if (mHeaderViewInfos == null)
            mHeaderViewInfos = new ArrayList<>();
    }


    @Override
    public int getItemViewType(int position) {
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return RecyclerView.INVALID_TYPE;
        }
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                return mAdapter.getItemViewType(adjPosition);
            }
        }
        return RecyclerView.INVALID_TYPE - 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == RecyclerView.INVALID_TYPE) {
            return new HeaderViewHolder(mHeaderViewInfos.get(0));
        } else if (viewType == RecyclerView.INVALID_TYPE - 1) {
            return new HeaderViewHolder(mFooterViewInfos.get(0));
        } else
            return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return;
        }
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                mAdapter.onBindViewHolder(holder, adjPosition);
                return;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mAdapter != null) {
            return getFootersCount() + getHeadersCount() + mAdapter.getItemCount();
        } else {
            return getFootersCount() + getHeadersCount();
        }
    }

    private int getHeadersCount() {
        return mHeaderViewInfos.size();
    }

    private int getFootersCount() {
        return mFooterViewInfos.size();
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
