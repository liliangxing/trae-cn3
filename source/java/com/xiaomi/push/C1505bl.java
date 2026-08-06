package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.xiaomi.push.bl */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1505bl {

    /* renamed from: a */
    private static volatile C1505bl f1074a;

    /* renamed from: a */
    private Context f1075a;

    private C1505bl(Context context) {
        this.f1075a = context;
    }

    /* renamed from: a */
    public static C1505bl m1672a(Context context) {
        if (f1074a == null) {
            synchronized (C1505bl.class) {
                if (f1074a == null) {
                    f1074a = new C1505bl(context);
                }
            }
        }
        return f1074a;
    }

    /* renamed from: a */
    public synchronized void m1676a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f1075a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    /* renamed from: a */
    public synchronized void m1675a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f1075a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    /* renamed from: a */
    public synchronized String m1674a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f1075a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a */
    public synchronized long m1673a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f1075a.getSharedPreferences(str, 4).getLong(str2, j);
    }
}
