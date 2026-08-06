package com.huawei.hms.opendevice;

import android.util.Log;

/* compiled from: TaskWrapper.java */
/* loaded from: classes6.dex */
public class o implements Runnable {
    private final Runnable a;

    public o(Runnable runnable) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.a;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable unused) {
                Log.e("HmsPushThreads", "exception in task run");
            }
        }
    }
}
