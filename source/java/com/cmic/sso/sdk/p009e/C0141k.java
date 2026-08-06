package com.cmic.sso.sdk.p009e;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* compiled from: SharedPreferencesUtil.java */
/* renamed from: com.cmic.sso.sdk.e.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0141k {

    /* renamed from: a */
    private static Context f323a;

    /* renamed from: a */
    public static void m369a(Context context) {
        f323a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static int m363a(String str, int i) {
        return f323a.getSharedPreferences("ssoconfigs", 0).getInt(C0134d.m329a(str), i);
    }

    /* renamed from: a */
    public static int m364a(String str, String str2, int i) {
        return f323a.getSharedPreferences(str, 0).getInt(C0134d.m329a(str2), i);
    }

    /* renamed from: a */
    public static long m365a(String str, long j) {
        return f323a.getSharedPreferences("ssoconfigs", 0).getLong(C0134d.m329a(str), j);
    }

    /* renamed from: a */
    public static long m366a(String str, String str2, long j) {
        return f323a.getSharedPreferences(str, 0).getLong(C0134d.m329a(str2), j);
    }

    /* renamed from: a */
    public static void m371a(String str, String str2) {
        SharedPreferences sharedPreferences = f323a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(C0134d.m329a(str), str2).commit();
    }

    /* renamed from: a */
    public static void m372a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = f323a.getSharedPreferences("ssoconfigs", 0).edit();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            String m329a = C0134d.m329a(str);
            if (obj instanceof String) {
                edit.putString(m329a, (String) obj);
            } else if (obj instanceof Integer) {
                edit.putInt(m329a, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                edit.putLong(m329a, ((Long) obj).longValue());
            } else if (obj instanceof Boolean) {
                edit.putBoolean(m329a, ((Boolean) obj).booleanValue());
            }
        }
        edit.commit();
    }

    /* renamed from: b */
    public static String m374b(String str, String str2) {
        return f323a.getSharedPreferences("ssoconfigs", 0).getString(C0134d.m329a(str), str2);
    }

    /* renamed from: a */
    public static String m368a(String str, String str2, String str3) {
        return f323a.getSharedPreferences(str, 0).getString(C0134d.m329a(str2), str3);
    }

    /* renamed from: a */
    public static void m370a(String str) {
        SharedPreferences sharedPreferences = f323a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().remove(C0134d.m329a(str)).commit();
    }

    /* renamed from: a */
    public static a m367a() {
        return new a(f323a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    /* renamed from: b */
    public static a m373b(String str) {
        return new a(f323a.getSharedPreferences(str, 0).edit());
    }

    /* compiled from: SharedPreferencesUtil.java */
    /* renamed from: com.cmic.sso.sdk.e.k$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class a {

        /* renamed from: a */
        private final SharedPreferences.Editor f324a;

        a(SharedPreferences.Editor editor) {
            this.f324a = editor;
        }

        /* renamed from: a */
        public void m379a(String str, String str2) {
            this.f324a.putString(C0134d.m329a(str), str2);
        }

        /* renamed from: a */
        public void m378a(String str, long j) {
            this.f324a.putLong(C0134d.m329a(str), j);
        }

        /* renamed from: a */
        public void m377a(String str, int i) {
            this.f324a.putInt(C0134d.m329a(str), i);
        }

        /* renamed from: a */
        public void m375a() {
            this.f324a.apply();
        }

        /* renamed from: b */
        public void m380b() {
            this.f324a.commit();
        }

        /* renamed from: c */
        public void m381c() {
            this.f324a.clear();
        }

        /* renamed from: a */
        public void m376a(String str) {
            this.f324a.remove(C0134d.m329a(str));
        }
    }
}
