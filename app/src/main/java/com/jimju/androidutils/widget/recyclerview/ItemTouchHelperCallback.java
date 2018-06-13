package com.jimju.androidutils.recyclerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.View;

import com.jimju.androidutils.R;

/**
 * Created by jimju on 2018/3/1.
 */

public class ItemTouchHelperCallback extends Callback {
    private ItemTouchMoveListener moveListener;

    public ItemTouchHelperCallback(ItemTouchMoveListener moveListener) {
        this.moveListener = moveListener;
    }

    //Callback回调监听时先调用的，用来判断当前是什么动作，比如判断方向（意思就是我要监听哪个方向的拖动）
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //方向：up,down,left,right 代表值为：1 ， 2， 4 ，8
        //常量
        int up = ItemTouchHelper.UP; // 0x0001
        int down = ItemTouchHelper.DOWN; //0x0010
        //需要监听上下方向
        int dragFlags = up | down; //  0x0001 | 0x0010 = 0x0011
        // 需要监听左右方向swipe
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT; // 0x0100 | 0x1000 = 0x1100

        int flags = makeMovementFlags(dragFlags, swipeFlags);
        return flags;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        //允许长按拖拽效果
        return true;
    }

    //当移动的时候回调的方法 -- 拖拽
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //在拖拽过程中会不断调用这个方法
        if (viewHolder.getItemViewType() != target.getItemViewType())
            return false;
        boolean result = moveListener.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return result;
    }

    //侧滑的时候回调
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        moveListener.onItemRemove(viewHolder.getAdapterPosition());
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        //判断选中的状态
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE){
            viewHolder.itemView.setScaleY(1.2f);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    /*
    拖拽结束之后回调
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        View itemView = viewHolder.itemView;
//        itemView.setAlpha(1);
//        itemView.setScaleX(1);
        itemView.setScaleY(1);
        super.clearView(recyclerView, viewHolder);
    }

    /**
     * 重绘child
     * @param c
     * @param recyclerView
     * @param viewHolder
     * @param dX
     * @param dY
     * @param actionState
     * @param isCurrentlyActive
     */
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        //dX:水平方向移动的量（负数往左，正数往右） 0-View.getWidth
        View itemView = viewHolder.itemView;
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
            //透明度动画
            float ani = 1- Math.abs(dX/itemView.getWidth()); // 0~ 1的数值
            //属性动画
//            itemView.setAlpha(ani);
//            itemView.setScaleX(ani);
            itemView.setScaleY(1);
          /*  if (Math.abs(dX) > itemView.getWidth() /2){
                dX = itemView.getWidth()/2 * (dX>0?1:-1);
            }*/
        }
        //判断是否超过或者达到width/2,
/*        if (dX <= itemView.getWidth()/2){
            itemView.setTranslationX(0.5f * itemView.getWidth());
        }else
        viewHolder.itemView.setTranslationX(dX);*/

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
