package com.bytedance.tobshadow.bdtracker;

import android.os.SystemClock;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;

/* renamed from: com.bytedance.tobshadow.bdtracker.t0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0517t0 {

    /* renamed from: a */
    public final IAppLogLogger f1044a;

    /* renamed from: b */
    public final String f1045b;

    /* renamed from: c */
    public long f1046c = -1;

    /* renamed from: d */
    public long f1047d = 0;

    public C0517t0(IAppLogLogger iAppLogLogger, String str) {
        this.f1044a = iAppLogLogger;
        this.f1045b = str;
    }

    /* renamed from: a */
    public void m667a(long j) {
        if (j <= 0 || this.f1046c <= 0) {
            return;
        }
        IAppLogLogger iAppLogLogger = this.f1044a;
        if (iAppLogLogger != null) {
            iAppLogLogger.debug(4, "[DurationEvent:{}] Pause at:{}", this.f1045b, Long.valueOf(j));
        }
        long j2 = this.f1047d;
        if (j <= this.f1046c) {
            j = SystemClock.elapsedRealtime();
        }
        this.f1047d = (j - this.f1046c) + j2;
        this.f1046c = -1L;
    }

    /* renamed from: b */
    public void m668b(long j) {
        if (j <= 0 || this.f1046c >= 0) {
            return;
        }
        m669c(j);
        IAppLogLogger iAppLogLogger = this.f1044a;
        if (iAppLogLogger != null) {
            iAppLogLogger.debug(4, "[DurationEvent:{}] Resume at:{}", this.f1045b, Long.valueOf(j));
        }
    }

    /* renamed from: c */
    public void m669c(long j) {
        this.f1046c = j;
        IAppLogLogger iAppLogLogger = this.f1044a;
        if (iAppLogLogger != null) {
            iAppLogLogger.debug(4, "[DurationEvent:{}] Start at:{}", this.f1045b, Long.valueOf(j));
        }
    }
}
