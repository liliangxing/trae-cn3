package com.cmic.sso.sdk.p009e;

import android.util.Log;

/* compiled from: LogUtils.java */
/* renamed from: com.cmic.sso.sdk.e.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0133c {

    /* renamed from: a */
    private static final C0133c f307a = new C0133c();

    /* renamed from: b */
    private static boolean f308b = false;

    /* renamed from: a */
    public static void m327a(boolean z) {
        f308b = z;
    }

    /* renamed from: a */
    public static void m326a(String str, String str2) {
        if (f308b) {
            Log.e("CMCC-SDK:" + str, "" + str2);
        }
    }

    /* renamed from: b */
    public static void m328b(String str, String str2) {
        if (f308b) {
            Log.d("CMCC-SDK:" + str, "" + str2);
        }
    }
}
