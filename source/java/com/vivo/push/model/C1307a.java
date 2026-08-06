package com.vivo.push.model;

import android.text.TextUtils;

/* compiled from: PushPackageInfo.java */
/* renamed from: com.vivo.push.model.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1307a {

    /* renamed from: a */
    private String f532a;

    /* renamed from: d */
    private String f535d;

    /* renamed from: b */
    private long f533b = -1;

    /* renamed from: c */
    private int f534c = -1;

    /* renamed from: e */
    private boolean f536e = false;

    /* renamed from: f */
    private boolean f537f = false;

    public C1307a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.f532a = str;
    }

    /* renamed from: a */
    public final String m802a() {
        return this.f532a;
    }

    /* renamed from: b */
    public final long m807b() {
        return this.f533b;
    }

    /* renamed from: a */
    public final void m804a(long j) {
        this.f533b = j;
    }

    /* renamed from: c */
    public final boolean m808c() {
        return this.f536e;
    }

    /* renamed from: d */
    public final boolean m809d() {
        return this.f537f;
    }

    /* renamed from: a */
    public final void m806a(boolean z) {
        this.f537f = z;
    }

    /* renamed from: a */
    public final void m803a(int i) {
        this.f534c = i;
    }

    /* renamed from: a */
    public final void m805a(String str) {
        this.f535d = str;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f532a + ", mPushVersion=" + this.f533b + ", mPackageVersion=" + this.f534c + ", mInBlackList=" + this.f536e + ", mPushEnable=" + this.f537f + "}";
    }
}
