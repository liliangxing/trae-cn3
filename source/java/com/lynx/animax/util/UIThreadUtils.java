package com.lynx.animax.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes6.dex */
public class UIThreadUtils {
    private static volatile Handler sMainHandler;

    public static Handler getUiThreadHandler() {
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
        if (!isOnUiThread()) {
            throw new AssertionError("Expected to run on UI thread!");
        }
    }

    public static void assertNotOnUiThread() {
        if (isOnUiThread()) {
            throw new AssertionError("Expected not to run on UI thread!");
        }
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

    public static void postAsynchronousAtFrontOfQueueOnUiThread(Runnable runnable) {
        Handler uiThreadHandler = getUiThreadHandler();
        Message obtain = Message.obtain(uiThreadHandler, runnable);
        obtain.setAsynchronous(true);
        uiThreadHandler.sendMessageAtFrontOfQueue(obtain);
    }
}
