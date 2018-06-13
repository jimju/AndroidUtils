package com.jimju.androidutils.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.jimju.androidutils.R;

/**
 * Created by jimju on 2018/2/26.
 */

public class GridItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private int[] attrs = new int[]{
            android.R.attr.listDivider
    };

    public GridItemDecoration(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        mDivider = typedArray.getDrawable(0);

    }

    public GridItemDecoration(Drawable drawable) {
        mDivider = drawable;
    }

    /**
     * 绘制水平线线
     */
    private void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin + (int) ViewCompat.getTranslationX(child);
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    /**
     * 绘制垂直线
     */
    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin + (int) ViewCompat.getTranslationY(child);
            int right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawHorizontal(c, parent);
        drawVertical(c, parent);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int right = mDivider.getIntrinsicWidth();
        int bottom = mDivider.getIntrinsicHeight();
        int position = parent.getChildAdapterPosition(view);
        Log.e("position", "position " + position);
        if (isLastColumn(position, parent))
            right = 0;
        if (isLastRow(position, parent)) {
            bottom = 0;
        }

        outRect.set(0, 0, right, bottom);

    }

    private boolean isLastRow(int position, RecyclerView parent) {
        int count = getSpanCount(parent);
        int childCount = parent.getAdapter().getItemCount();
        int lastRow = childCount % count;
        //最后一行的数量小于spanCount
        if (childCount - position <= lastRow) {
            return true;
        }
        return false;
    }

    private int getSpanCount(RecyclerView parent) {
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager lm = (GridLayoutManager) parent.getLayoutManager();
            int spanCount = lm.getSpanCount();
            return spanCount;
        }
        return 0;
    }


    private boolean isLastColumn(int position, RecyclerView parent) {
        int count = getSpanCount(parent);
        return count > 0 && (position + 1) % count == 0;
    }
}
