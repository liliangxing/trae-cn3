package com.cmic.sso.sdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* compiled from: SharedPreferencesUtil.java */
/* loaded from: classes6.dex */
public class k {
    private static Context a;

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    public static int a(String str, int i) {
        return a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i);
    }

    public static int a(String str, String str2, int i) {
        return a.getSharedPreferences(str, 0).getInt(d.a(str2), i);
    }

    public static long a(String str, long j) {
        return a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
    }

    public static long a(String str, String str2, long j) {
        return a.getSharedPreferences(str, 0).getLong(d.a(str2), j);
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static void a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = a.getSharedPreferences("ssoconfigs", 0).edit();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            String a2 = d.a(str);
            if (obj instanceof String) {
                edit.putString(a2, (String) obj);
            } else if (obj instanceof Integer) {
                edit.putInt(a2, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                edit.putLong(a2, ((Long) obj).longValue());
            } else if (obj instanceof Boolean) {
                edit.putBoolean(a2, ((Boolean) obj).booleanValue());
            }
        }
        edit.commit();
    }

    public static String b(String str, String str2) {
        return a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }

    public static String a(String str, String str2, String str3) {
        return a.getSharedPreferences(str, 0).getString(d.a(str2), str3);
    }

    public static void a(String str) {
        SharedPreferences sharedPreferences = a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().remove(d.a(str)).commit();
    }

    public static a a() {
        return new a(a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    public static a b(String str) {
        return new a(a.getSharedPreferences(str, 0).edit());
    }

    /* compiled from: SharedPreferencesUtil.java */
    /* loaded from: classes6.dex */
    public static class a {
        private final SharedPreferences.Editor a;

        a(SharedPreferences.Editor editor) {
            this.a = editor;
        }

        public void a(String str, String str2) {
            this.a.putString(d.a(str), str2);
        }

        public void a(String str, long j) {
            this.a.putLong(d.a(str), j);
        }

        public void a(String str, int i) {
            this.a.putInt(d.a(str), i);
        }

        public void a() {
            this.a.apply();
        }

        public void b() {
            this.a.commit();
        }

        public void c() {
            this.a.clear();
        }

        public void a(String str) {
            this.a.remove(d.a(str));
        }
    }
}
