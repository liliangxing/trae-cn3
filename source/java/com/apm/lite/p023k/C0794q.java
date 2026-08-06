package com.apm.lite.p023k;

import android.util.Log;
import com.apm.lite.C0749e;

/* renamed from: com.apm.lite.k.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0794q {
    /* renamed from: a */
    public static void m887a(Object obj) {
        if (C0749e.m567i().isDebugMode()) {
            Log.i("npth", String.valueOf(obj));
        }
    }

    /* renamed from: a */
    public static void m888a(String str) {
        if (C0749e.m567i().isDebugMode()) {
            Log.w("npth", str);
        }
    }

    /* renamed from: a */
    public static void m889a(String str, Object obj) {
        if (C0749e.m567i().isDebugMode()) {
            Log.i("npth", str + " " + obj);
        }
    }

    /* renamed from: a */
    public static void m890a(String str, Object obj, Throwable th) {
        if (C0749e.m567i().isDebugMode()) {
            Log.e("npth", str + " " + obj, th);
        }
    }

    /* renamed from: a */
    public static void m891a(String str, Throwable th) {
        if (C0749e.m567i().isDebugMode()) {
            Log.e("npth", str + " NPTH Catch Error", th);
        }
    }

    /* renamed from: a */
    public static void m892a(Throwable th) {
        if (C0749e.m567i().isDebugMode()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    /* renamed from: b */
    public static void m893b(Throwable th) {
        if (C0749e.m567i().isDebugMode()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }
}
