package com.bytedance.ug.sdk.share.impl.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class MainThreadUtils {
    private static final Handler sMainHandler = new Handler(Looper.getMainLooper());

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void runOnMainThread(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            sMainHandler.post(runnable);
        }
    }
}
