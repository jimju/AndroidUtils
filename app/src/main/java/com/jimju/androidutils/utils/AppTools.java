package com.jimju.androidutils.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by jimju on 2018/2/24.
 */

public class AppTools {
    public static List<ApplicationInfo> getApps(Context context) {
        List<ApplicationInfo> apps = new ArrayList<>();
        List<ApplicationInfo> list = new ArrayList<>();
        try {
            PackageManager pm = context.getPackageManager();
            list = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
            Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
            HashSet<String> packages = new HashSet<>();
            for (ResolveInfo ri : resolveInfos) {
                packages.add(ri.activityInfo.packageName);
            }
            for (ApplicationInfo pi : list) {
                if (packages.contains(pi.packageName))
                    apps.add(pi);
            }
        } catch (Exception e) {

        }
        return apps;
    }

    /**
     * Helper method to get an applications name!
     *
     * @return
     */

    public static String getNameFromInfo(Context ctx, ApplicationInfo ai) {
        Resources res = null;
        String name = "";
        try {
            res = ctx.getPackageManager().getResourcesForApplication(ai);
            name = res.getString(ai.labelRes);
        } catch (Exception e) {
            e.printStackTrace();
            name = ai.packageName;
        }
        return name;
    }

    public static Drawable getIconFromInfo(Context ctx, ApplicationInfo ai){
        return ai.loadIcon(ctx.getPackageManager());
    }

}
