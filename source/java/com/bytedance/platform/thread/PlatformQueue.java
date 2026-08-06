package com.bytedance.platform.thread;

/* loaded from: classes4.dex */
public class PlatformQueue {
    public static void runOnUiThread(Runnable runnable, long j) {
        PlatformHandlerThread.getDefaultMainHandler().postDelayed(runnable, j);
    }

    public static void runOnUiThread(Runnable runnable) {
        PlatformHandlerThread.getDefaultMainHandler().post(runnable);
    }

    public static void runOnThread(Runnable runnable) {
        PlatformHandlerThread.getDefaultHandler().post(runnable);
    }

    public static void runOnBackThread(Runnable runnable) {
        PlatformHandlerThread.getBackgroundHandler().post(runnable);
    }
}
