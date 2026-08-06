package com.huawei.hms.opendevice;

import android.util.Log;

/* compiled from: TaskWrapper.java */
/* renamed from: com.huawei.hms.opendevice.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC1207o implements Runnable {

    /* renamed from: a */
    private final Runnable f1615a;

    public RunnableC1207o(Runnable runnable) {
        this.f1615a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f1615a;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable unused) {
                Log.e("HmsPushThreads", "exception in task run");
            }
        }
    }
}
