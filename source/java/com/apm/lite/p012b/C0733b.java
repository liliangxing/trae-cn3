package com.apm.lite.p012b;

import android.os.SystemClock;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.apm.lite.runtime.C0821b;
import com.apm.lite.runtime.C0832m;

/* renamed from: com.apm.lite.b.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0733b {

    /* renamed from: b */
    private static long f381b;

    /* renamed from: a */
    private final C0732a f382a;

    /* renamed from: c */
    private boolean f383c = false;

    /* renamed from: d */
    private final Runnable f384d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0733b(C0732a c0732a) {
        Runnable runnable = new Runnable() { // from class: com.apm.lite.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (C0733b.this.f383c) {
                    return;
                }
                C0733b.this.f382a.m410c();
                long unused = C0733b.f381b = SystemClock.uptimeMillis();
                C0832m.m1190b().m1239a(C0733b.this.f384d, 500L);
                C0821b.m1108a(C0733b.f381b);
            }
        };
        this.f384d = runnable;
        this.f382a = c0732a;
        C0832m.m1190b().m1239a(runnable, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    /* renamed from: a */
    public void m419a() {
        if (this.f383c) {
            return;
        }
        C0832m.m1190b().m1239a(this.f384d, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }
}
