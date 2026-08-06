package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1494ba;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1789r {

    /* renamed from: a */
    private static C1789r f3204a;

    /* renamed from: a */
    private Context f3205a;

    /* renamed from: a */
    private List<String> f3206a = new ArrayList();

    /* renamed from: b */
    private final List<String> f3207b = new ArrayList();

    /* renamed from: c */
    private final List<String> f3208c = new ArrayList();

    /* renamed from: a */
    public static C1789r m3965a(Context context) {
        if (f3204a == null) {
            f3204a = new C1789r(context);
        }
        return f3204a;
    }

    private C1789r(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f3205a = applicationContext;
        if (applicationContext == null) {
            this.f3205a = context;
        }
        SharedPreferences sharedPreferences = this.f3205a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f3206a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f3207b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f3208c.add(str3);
            }
        }
    }

    /* renamed from: a */
    public boolean m3967a(String str) {
        boolean contains;
        synchronized (this.f3206a) {
            contains = this.f3206a.contains(str);
        }
        return contains;
    }

    /* renamed from: b */
    public boolean m3969b(String str) {
        boolean contains;
        synchronized (this.f3207b) {
            contains = this.f3207b.contains(str);
        }
        return contains;
    }

    /* renamed from: c */
    public boolean m3971c(String str) {
        boolean contains;
        synchronized (this.f3208c) {
            contains = this.f3208c.contains(str);
        }
        return contains;
    }

    /* renamed from: a */
    public void m3966a(String str) {
        synchronized (this.f3206a) {
            if (!this.f3206a.contains(str)) {
                this.f3206a.add(str);
                this.f3205a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C1494ba.m1627a(this.f3206a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: b */
    public void m3968b(String str) {
        synchronized (this.f3207b) {
            if (!this.f3207b.contains(str)) {
                this.f3207b.add(str);
                this.f3205a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", C1494ba.m1627a(this.f3207b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: c */
    public void m3970c(String str) {
        synchronized (this.f3208c) {
            if (!this.f3208c.contains(str)) {
                this.f3208c.add(str);
                this.f3205a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", C1494ba.m1627a(this.f3208c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: d */
    public void m3972d(String str) {
        synchronized (this.f3206a) {
            if (this.f3206a.contains(str)) {
                this.f3206a.remove(str);
                this.f3205a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C1494ba.m1627a(this.f3206a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: e */
    public void m3973e(String str) {
        synchronized (this.f3207b) {
            if (this.f3207b.contains(str)) {
                this.f3207b.remove(str);
                this.f3205a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", C1494ba.m1627a(this.f3207b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: f */
    public void m3974f(String str) {
        synchronized (this.f3208c) {
            if (this.f3208c.contains(str)) {
                this.f3208c.remove(str);
                this.f3205a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", C1494ba.m1627a(this.f3208c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
