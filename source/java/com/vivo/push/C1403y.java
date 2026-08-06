package com.vivo.push;

import android.os.SystemClock;

/* compiled from: RequestFrequencyControl.java */
/* renamed from: com.vivo.push.y */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1403y {

    /* renamed from: a */
    private volatile long f734a = -1;

    /* renamed from: a */
    public final synchronized boolean m1071a() {
        boolean z;
        long j = this.f734a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        z = j != -1 && elapsedRealtime > j && elapsedRealtime < j + 2000;
        this.f734a = SystemClock.elapsedRealtime();
        return z;
    }
}
