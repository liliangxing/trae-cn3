package com.bytedance.sdk.open.aweme.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public class ThreadUtils {
    private static ExecutorService executorService;
    private static Handler mainHandler;

    private static ExecutorService getExecutorService() {
        if (executorService == null) {
            synchronized (ThreadUtils.class) {
                if (executorService == null) {
                    executorService = Executors.newCachedThreadPool();
                }
            }
        }
        return executorService;
    }

    public static Handler getMainHandler() {
        if (mainHandler == null) {
            synchronized (ThreadUtils.class) {
                if (mainHandler == null) {
                    mainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return mainHandler;
    }

    public static boolean isUIThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void postInMain(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (isUIThread()) {
            runnable.run();
        } else {
            getMainHandler().post(runnable);
        }
    }

    public static void summit(Runnable runnable) {
        ExecutorService executorService2 = getExecutorService();
        if (executorService2 != null) {
            executorService2.submit(runnable);
        }
    }
}
