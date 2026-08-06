package cn.com.chinatelecom.account.api.p010e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* renamed from: cn.com.chinatelecom.account.api.e.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0696c {
    /* renamed from: a */
    private static SharedPreferences m288a(Context context) {
        return context.getSharedPreferences(m294b(context), 0);
    }

    /* renamed from: a */
    public static void m289a(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            m288a(context).edit().putInt(str, i).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m290a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            m288a(context).edit().putString(str, str2).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m291a(Context context, String str, long j) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return m288a(context).edit().putLong(str, j).commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static int m292b(Context context, String str, int i) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return m288a(context).getInt(str, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /* renamed from: b */
    public static long m293b(Context context, String str, long j) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return m288a(context).getLong(str, j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    /* renamed from: b */
    private static String m294b(Context context) {
        return "ct_account_api_sdk";
    }

    /* renamed from: b */
    public static String m295b(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return m288a(context).getString(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str2;
    }
}
