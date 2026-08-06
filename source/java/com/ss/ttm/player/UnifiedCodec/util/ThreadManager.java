package com.ss.ttm.player.UnifiedCodec.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes7.dex */
public final class ThreadManager {
    private static final HandlerThread mHandlerThread;
    private static final ExecutorService mThreadPool = Executors.newCachedThreadPool();
    private static final Handler sHandler;

    static {
        HandlerThread handlerThread = new HandlerThread("unifycodec-thread");
        mHandlerThread = handlerThread;
        handlerThread.start();
        sHandler = new Handler(handlerThread.getLooper());
    }

    private ThreadManager() {
    }

    public static void execute(Runnable runnable) {
        mThreadPool.execute(runnable);
    }

    public static void postRunnable(Runnable runnable) {
        sHandler.post(runnable);
    }

    public static void runInSub(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            mThreadPool.execute(runnable);
        } else {
            runnable.run();
        }
    }
}
