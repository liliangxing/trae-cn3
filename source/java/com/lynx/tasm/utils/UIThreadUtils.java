package com.lynx.tasm.utils;

import android.os.Handler;
import android.os.Looper;
import com.lynx.tasm.base.Assertions;

/* loaded from: classes7.dex */
public class UIThreadUtils {
    private static volatile Handler sMainHandler;

    private static Handler getUiThreadHandler() {
        if (sMainHandler == null) {
            synchronized (UIThreadUtils.class) {
                if (sMainHandler == null) {
                    sMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return sMainHandler;
    }

    public static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void assertOnUiThread() {
        Assertions.assertCondition(isOnUiThread(), "Expected to run on UI thread!");
    }

    public static void assertNotOnUiThread() {
        Assertions.assertCondition(!isOnUiThread(), "Expected not to run on UI thread!");
    }

    public static void runOnUiThread(Runnable runnable) {
        getUiThreadHandler().post(runnable);
    }

    public static void postAtFrontOfQueueOnUiThread(Runnable runnable) {
        getUiThreadHandler().postAtFrontOfQueue(runnable);
    }

    public static void runOnUiThreadImmediately(Runnable runnable) {
        if (isOnUiThread()) {
            runnable.run();
        } else {
            runOnUiThread(runnable);
        }
    }

    public static void runOnUiThreadImmediatelyWithPostAtFront(Runnable runnable) {
        if (isOnUiThread()) {
            runnable.run();
        } else {
            postAtFrontOfQueueOnUiThread(runnable);
        }
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        getUiThreadHandler().postDelayed(runnable, j);
    }

    public static void runOnUiThreadAtTime(Runnable runnable, Object obj, long j) {
        getUiThreadHandler().postAtTime(runnable, obj, j);
    }

    public static void removeCallbacks(Runnable runnable, Object obj) {
        getUiThreadHandler().removeCallbacks(runnable, obj);
    }
}
