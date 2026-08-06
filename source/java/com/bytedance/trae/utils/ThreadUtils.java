package com.bytedance.trae.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes4.dex */
public class ThreadUtils {
    private static final Handler backgroundHandler;
    public static final Handler mainHandler = new Handler(Looper.getMainLooper());

    static {
        HandlerThread handlerThread = new HandlerThread("background_thread_utils");
        handlerThread.start();
        backgroundHandler = new Handler(handlerThread.getLooper());
    }

    public static void postInBackground(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        backgroundHandler.post(new SafeWrapper(runnable));
    }

    public static void postInBackground(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        backgroundHandler.postDelayed(new SafeWrapper(runnable), j);
    }

    public static void postInForeground(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        mainHandler.post(new SafeWrapper(runnable));
    }

    public static void postInForeground(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        mainHandler.postDelayed(new SafeWrapper(runnable), j);
    }

    public static void postInForegroundAtFrontOfQueue(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        mainHandler.postAtFrontOfQueue(new SafeWrapper(runnable));
    }

    public static void runInMain(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            postInForeground(runnable);
        }
    }

    public static void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (Exception unused) {
        }
    }

    public static Handler getBackgroundHandler() {
        return backgroundHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class SafeWrapper implements Runnable {
        final Runnable target;

        private SafeWrapper(Runnable runnable) {
            this.target = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.target;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                }
            }
        }
    }
}
