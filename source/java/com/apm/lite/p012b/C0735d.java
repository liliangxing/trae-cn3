package com.apm.lite.p012b;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.apm.lite.b.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0735d {

    /* renamed from: a */
    private static volatile C0735d f390a;

    /* renamed from: b */
    private final C0732a f391b;

    private C0735d(Context context) {
        this.f391b = new C0732a(context);
    }

    /* renamed from: a */
    public static C0735d m426a(Context context) {
        if (f390a == null) {
            synchronized (C0735d.class) {
                if (f390a == null) {
                    f390a = new C0735d(context);
                }
            }
        }
        return f390a;
    }

    /* renamed from: a */
    public static JSONArray m427a() {
        return new JSONArray();
    }

    /* renamed from: a */
    public static JSONObject m428a(long j) {
        return new JSONObject();
    }

    /* renamed from: c */
    public static void m429c() {
        if (f390a == null || f390a.f391b == null) {
            return;
        }
        f390a.f391b.m409b();
    }

    /* renamed from: d */
    public static void m430d() {
        if (f390a == null || f390a.f391b == null) {
            return;
        }
        f390a.f391b.m412e();
    }

    /* renamed from: e */
    public static void m431e() {
        if (f390a == null || f390a.f391b == null) {
            return;
        }
        f390a.f391b.m411d();
    }

    /* renamed from: b */
    public void m432b() {
        this.f391b.m407a();
    }
}
