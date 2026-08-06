package com.bytedance.crash.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

@Deprecated
/* loaded from: classes3.dex */
public class NpthHandlerThread {
    private static final String THREAD_NAME = "default_npth_thread";
    private static volatile ThreadWithHandler defaultHandlerThread;
    private static volatile Handler defaultMainHandler;

    public static void stopOtherTask() {
    }

    public static HandlerThread getDefaultHandlerThread() {
        if (defaultHandlerThread == null) {
            synchronized (NpthHandlerThread.class) {
                if (defaultHandlerThread == null) {
                    defaultHandlerThread = new ThreadWithHandler(THREAD_NAME);
                    defaultHandlerThread.start();
                }
            }
        }
        return defaultHandlerThread.getThread();
    }

    public static ThreadWithHandler getDefaultHandler() {
        if (defaultHandlerThread == null) {
            getDefaultHandlerThread();
        }
        return defaultHandlerThread;
    }

    public static Handler getMainThreadHandler() {
        if (defaultMainHandler == null) {
            defaultMainHandler = new Handler(Looper.getMainLooper());
        }
        return defaultMainHandler;
    }
}
