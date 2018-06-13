package com.jimju.androidutils.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/8/5.
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerHolder>{

    protected List<T> mCollection;
    protected Context mCxt;
    private int layoutId;
    private OnItemClickListener listener;

    public BaseRecyclerAdapter(List<T> mCollection, Context mCxt, int layoutId) {
        this.mCollection = mCollection;
        this.mCxt = mCxt;
        this.layoutId = layoutId;
    }

    /**
     * 给适配器填充数据
     * @param holder
     * @param item
     */
    public abstract void convert(RecyclerHolder holder,T item);


    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCxt);
        View itemView = inflater.inflate(layoutId,parent,false);
        return new RecyclerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        convert(holder,mCollection.get(position));
        holder.itemView.setOnClickListener(new ItemViewClickListener(position));
    }


    @Override
    public int getItemCount() {
        return mCollection == null ?0:mCollection.size();
    }

    public void setOnItemClickLister(OnItemClickListener listener) {
        this.listener = listener;
    }

    private class ItemViewClickListener implements View.OnClickListener {
        private int position;

        public ItemViewClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            if (listener!=null)
                listener.onItemClick(position);
        }
    }

    public static interface OnItemClickListener{
        public void onItemClick(int position);
    }
}
