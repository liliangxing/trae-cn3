package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class r5 {
    public static final Map<String, Boolean> a = new ConcurrentHashMap();
    public static final Map<String, PackageInfo> b = new ConcurrentHashMap();

    public static int a(Context context) {
        PackageInfo a2 = a(context, context.getPackageName(), 0);
        if (a2 != null) {
            return a2.versionCode;
        }
        return 0;
    }

    public static PackageInfo a(Context context, String str, int i) {
        PackageInfo packageInfo;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = i + Constants.COLON_SEPARATOR + context.hashCode() + "@" + str;
        Map<String, PackageInfo> map = b;
        synchronized (map) {
            if (!map.containsKey(str2)) {
                try {
                    map.put(str2, context.getPackageManager().getPackageInfo(str, i));
                } catch (Throwable unused) {
                }
            }
            packageInfo = b.get(str2);
        }
        return packageInfo;
    }

    public static boolean a(Context context, String str) {
        boolean equals;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = context.hashCode() + "@" + str;
        Map<String, Boolean> map = a;
        synchronized (map) {
            if (!map.containsKey(str2)) {
                try {
                    map.put(str2, Boolean.valueOf(context.getPackageManager().getPackageInfo(str, 16384) != null));
                } catch (Throwable unused) {
                    a.put(str2, false);
                }
            }
            equals = Boolean.TRUE.equals(a.get(str2));
        }
        return equals;
    }

    public static String b(Context context) {
        PackageInfo a2 = a(context, context.getPackageName(), 0);
        return a2 != null ? a2.versionName : "";
    }
}
