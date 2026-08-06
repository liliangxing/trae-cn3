package com.bytedance.apm.util;

import android.os.Looper;

/* loaded from: classes3.dex */
public class ThreadUtils {
    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void sleepSafely(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }
}
