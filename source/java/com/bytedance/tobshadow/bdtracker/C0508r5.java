package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.bytedance.tobshadow.bdtracker.r5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0508r5 {

    /* renamed from: a */
    public static final Map<String, Boolean> f979a = new ConcurrentHashMap();

    /* renamed from: b */
    public static final Map<String, PackageInfo> f980b = new ConcurrentHashMap();

    /* renamed from: a */
    public static int m640a(Context context) {
        PackageInfo m641a = m641a(context, context.getPackageName(), 0);
        if (m641a != null) {
            return m641a.versionCode;
        }
        return 0;
    }

    /* renamed from: a */
    public static PackageInfo m641a(Context context, String str, int i) {
        PackageInfo packageInfo;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = i + ":" + context.hashCode() + "@" + str;
        Map<String, PackageInfo> map = f980b;
        synchronized (map) {
            if (!map.containsKey(str2)) {
                try {
                    map.put(str2, context.getPackageManager().getPackageInfo(str, i));
                } catch (Throwable unused) {
                }
            }
            packageInfo = f980b.get(str2);
        }
        return packageInfo;
    }

    /* renamed from: a */
    public static boolean m642a(Context context, String str) {
        boolean equals;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = context.hashCode() + "@" + str;
        Map<String, Boolean> map = f979a;
        synchronized (map) {
            if (!map.containsKey(str2)) {
                try {
                    map.put(str2, Boolean.valueOf(context.getPackageManager().getPackageInfo(str, 16384) != null));
                } catch (Throwable unused) {
                    f979a.put(str2, false);
                }
            }
            equals = Boolean.TRUE.equals(f979a.get(str2));
        }
        return equals;
    }

    /* renamed from: b */
    public static String m643b(Context context) {
        PackageInfo m641a = m641a(context, context.getPackageName(), 0);
        return m641a != null ? m641a.versionName : "";
    }
}
