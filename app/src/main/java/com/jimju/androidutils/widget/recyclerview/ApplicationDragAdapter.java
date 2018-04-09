package com.jimju.androidutils.recyclerview;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jimju.androidutils.R;
import com.jimju.androidutils.adapter.ApplicationsAdapter;
import com.jimju.androidutils.utils.AppTools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jimju on 2018/3/1.
 */

public class ApplicationDragAdapter extends Adapter<ApplicationDragAdapter.MyViewHolder> implements ItemTouchMoveListener{

    private List<ApplicationInfo> mDatas = new ArrayList<>();
    private StartDragListener mDragerListener;
    private Context mCxt;
    public ApplicationDragAdapter(Context context,StartDragListener listener) {
        this.mDatas = AppTools.getApps(context);
        this.mDragerListener = listener;
        this.mCxt = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drager_icon_text,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.image.setImageDrawable(AppTools.getIconFromInfo(mCxt,mDatas.get(position)));
        holder.text.setText(AppTools.getNameFromInfo(mCxt,mDatas.get(position)));
        holder.drager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    //传递触摸
                    mDragerListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        // 1.数据交换；2.刷新
        Collections.swap(mDatas, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public boolean onItemRemove(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
        return true;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView image,drager;
        private TextView text;
        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            drager = itemView.findViewById(R.id.image_drager);
            text = itemView.findViewById(R.id.text);
            drager.setVisibility(View.VISIBLE);
        }
    }
}
