package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.huawei.secure.android.common.ssl.util.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1304g {

    /* renamed from: a */
    private static final String f2210a = "aegis";

    /* renamed from: b */
    private static SharedPreferences f2211b;

    /* renamed from: a */
    public static long m2414a(String str, long j, Context context) {
        return m2418b(context).getLong(str, j);
    }

    /* renamed from: b */
    public static synchronized SharedPreferences m2418b(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (C1304g.class) {
            if (f2211b == null) {
                f2211b = context.createDeviceProtectedStorageContext().getSharedPreferences(f2210a, 0);
            }
            sharedPreferences = f2211b;
        }
        return sharedPreferences;
    }

    /* renamed from: a */
    public static int m2413a(String str, int i, Context context) {
        return m2418b(context).getInt(str, i);
    }

    /* renamed from: a */
    public static String m2415a(String str, String str2, Context context) {
        return m2418b(context).getString(str, str2);
    }

    /* renamed from: a */
    public static void m2417a(String str, Context context) {
        m2418b(context).edit().remove(str).apply();
    }

    /* renamed from: a */
    public static void m2416a(Context context) {
        m2418b(context).edit().clear().apply();
    }

    /* renamed from: b */
    public static void m2420b(String str, long j, Context context) {
        m2418b(context).edit().putLong(str, j).apply();
    }

    /* renamed from: b */
    public static void m2419b(String str, int i, Context context) {
        m2418b(context).edit().putInt(str, i).apply();
    }

    /* renamed from: b */
    public static void m2421b(String str, String str2, Context context) {
        m2418b(context).edit().putString(str, str2).apply();
    }
}
