package com.apm.lite.p017e;

import com.apm.lite.C0749e;
import com.apm.lite.p023k.C0795r;
import com.apm.lite.runtime.p024a.C0812b;

/* renamed from: com.apm.lite.e.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0754e {
    /* renamed from: a */
    public static boolean m615a(long j) {
        if (C0795r.m896a(2)) {
            return true;
        }
        if (C0795r.m896a(1024)) {
            return false;
        }
        return (C0812b.m1051c() == -1 || j - C0812b.m1051c() <= C0749e.m567i().getLaunchCrashInterval()) && !(C0749e.m571m() && C0749e.m574p() == 0);
    }
}
