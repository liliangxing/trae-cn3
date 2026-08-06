package com.lynx.tasm.core;

import android.util.Log;
import com.lynx.tasm.LynxEnv;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public final class LynxThreadPool {
    private static final String TAG = "lynx_LynxThreadPool";
    private static volatile Executor sAsyncLepusBridgeExecutor;
    private static volatile Executor sBriefIOExecutor;
    private static volatile Executor sCardServiceExecutor;
    private static volatile Executor sImageRequestExecutor;
    private static volatile Executor sSvgRenderExecutor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum ConcurrentTaskType {
        HIGH_PRIORITY
    }

    private LynxThreadPool() {
    }

    public static Executor getBriefIOExecutor() {
        if (sBriefIOExecutor == null) {
            synchronized (LynxThreadPool.class) {
                if (sBriefIOExecutor == null) {
                    sBriefIOExecutor = getExecutor("lynx-brief-io-thread", 3, 2);
                }
            }
        }
        return sBriefIOExecutor;
    }

    public static Executor getAsyncServiceExecutor() {
        if (sCardServiceExecutor == null) {
            synchronized (LynxThreadPool.class) {
                if (sCardServiceExecutor == null) {
                    sCardServiceExecutor = getExecutor("lynx-card-service-thread", 10, 2);
                }
            }
        }
        return sCardServiceExecutor;
    }

    public static Future<Runnable> postUIOperationTask(Callable<Runnable> callable) {
        final FutureTask futureTask = new FutureTask(callable);
        postTask(new Runnable() { // from class: com.lynx.tasm.core.LynxThreadPool.1
            @Override // java.lang.Runnable
            public void run() {
                futureTask.run();
            }
        }, ConcurrentTaskType.HIGH_PRIORITY);
        return futureTask;
    }

    public static void postUIOperationTask(Runnable runnable) {
        postTask(runnable, ConcurrentTaskType.HIGH_PRIORITY);
    }

    public static Executor getImageRequestExecutor() {
        if (sImageRequestExecutor == null) {
            synchronized (LynxThreadPool.class) {
                if (sImageRequestExecutor == null) {
                    sImageRequestExecutor = getExecutor("lynx-image-request-thread", 10, 1);
                }
            }
        }
        return sImageRequestExecutor;
    }

    public static Executor getSvgRenderExecutor() {
        if (sSvgRenderExecutor == null) {
            synchronized (LynxThreadPool.class) {
                if (sSvgRenderExecutor == null) {
                    sSvgRenderExecutor = getExecutor("lynx-svg-thread", 3, 1);
                }
            }
        }
        return sSvgRenderExecutor;
    }

    public static Executor getAsyncLepusBridgeExecutor() {
        if (sAsyncLepusBridgeExecutor == null) {
            synchronized (LynxThreadPool.class) {
                if (sAsyncLepusBridgeExecutor == null) {
                    sAsyncLepusBridgeExecutor = getExecutor("lepus-bridge-async-thread", 3, 1);
                }
            }
        }
        return sAsyncLepusBridgeExecutor;
    }

    private static boolean postTask(Runnable runnable, ConcurrentTaskType concurrentTaskType) {
        return LynxEnv.runJavaTaskOnConcurrentLoop(runnable, concurrentTaskType.ordinal());
    }

    private static Executor getExecutor(final String str, final int i, int i2) {
        try {
            return Executors.newFixedThreadPool(i2, new ThreadFactory() { // from class: com.lynx.tasm.core.LynxThreadPool.2
                private final AtomicInteger threadNumber = new AtomicInteger(1);

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.threadNumber.getAndIncrement());
                    if (thread.isDaemon()) {
                        thread.setDaemon(false);
                    }
                    thread.setPriority(i);
                    thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.lynx.tasm.core.LynxThreadPool.2.1
                        @Override // java.lang.Thread.UncaughtExceptionHandler
                        public void uncaughtException(Thread thread2, Throwable th) {
                            Log.e(LynxThreadPool.TAG, th.toString());
                        }
                    });
                    return thread;
                }
            });
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            return new Executor() { // from class: com.lynx.tasm.core.LynxThreadPool.3
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                }
            };
        }
    }
}
