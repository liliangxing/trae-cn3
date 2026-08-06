package com.vivo.push;

import android.os.SystemClock;

/* compiled from: RequestFrequencyControl.java */
/* loaded from: classes7.dex */
public final class y {
    private volatile long a = -1;

    public final synchronized boolean a() {
        boolean z;
        long j = this.a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        z = j != -1 && elapsedRealtime > j && elapsedRealtime < j + 2000;
        this.a = SystemClock.elapsedRealtime();
        return z;
    }
}
