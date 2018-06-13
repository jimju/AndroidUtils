package com.jimju.androidutils.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.widget.ImageView;
import android.widget.TextView;

import com.jimju.androidutils.R;
import com.jimju.androidutils.utils.AppTools;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/2/6.
 */

public class ApplicationsAdapter extends BaseRecyclerAdapter<ApplicationInfo> {


    public ApplicationsAdapter(List<ApplicationInfo> mCollection, Context context) {
        this(mCollection, context, R.layout.item_simple_icon_text);
    }

    public ApplicationsAdapter(Context context) {
        this(AppTools.getApps(context), context, R.layout.item_simple_icon_text);
    }

    public ApplicationsAdapter(List<ApplicationInfo> mCollection, Context context, int id) {
        super(mCollection, context, id);
    }


    @Override
    public void convert(RecyclerHolder holder, ApplicationInfo item) {
        TextView textView = holder.getView(R.id.text);
        ImageView imageView = holder.getView(R.id.image);
        textView.setText(AppTools.getNameFromInfo(mCxt, item));
        imageView.setImageDrawable(AppTools.getIconFromInfo(mCxt, item));
//        imageView.set
    }
}
