package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import com.lynx.tasm.animation.AnimationConstant;
import java.util.List;

/* compiled from: CommFun.java */
/* renamed from: com.huawei.hms.push.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1215e {
    /* renamed from: a */
    public static String m1949a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            HMSLog.m2120i("PushSelfShowLog", "get the app name of package:" + str + " failed.");
            return null;
        }
    }

    /* renamed from: b */
    public static Intent m1951b(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception unused) {
            HMSLog.m2121w("PushSelfShowLog", str + " not have launch activity");
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m1952b() {
        return true;
    }

    /* renamed from: c */
    public static boolean m1954c(Context context, String str) {
        if (context != null && str != null && !"".equals(str)) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, AnimationConstant.PROP_COLOR) == null) {
                    return false;
                }
                HMSLog.m2115d("PushSelfShowLog", str + " is installed");
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m1955d() {
        return true;
    }

    /* renamed from: a */
    public static Boolean m1948a(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                for (int i = 0; i < size; i++) {
                    if (queryIntentActivities.get(i).activityInfo != null && str.equals(queryIntentActivities.get(i).activityInfo.applicationInfo.packageName)) {
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e) {
            HMSLog.m2119e("PushSelfShowLog", e.toString(), e);
        }
        return Boolean.FALSE;
    }

    /* renamed from: c */
    public static boolean m1953c() {
        return Build.VERSION.SDK_INT >= 33;
    }

    /* renamed from: a */
    public static int m1947a() {
        return m1952b() ? 67108864 : 134217728;
    }

    /* renamed from: a */
    public static boolean m1950a(Context context) {
        return "com.huawei.hwid".equals(context.getPackageName());
    }
}
