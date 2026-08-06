package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes7.dex */
public class bl {
    private static volatile bl a;

    /* renamed from: a, reason: collision with other field name */
    private Context f205a;

    private bl(Context context) {
        this.f205a = context;
    }

    public static bl a(Context context) {
        if (a == null) {
            synchronized (bl.class) {
                if (a == null) {
                    a = new bl(context);
                }
            }
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m9666a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f205a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m9665a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f205a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f205a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized long a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f205a.getSharedPreferences(str, 4).getLong(str2, j);
    }
}
