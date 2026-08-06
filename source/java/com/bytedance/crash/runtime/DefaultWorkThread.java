package com.bytedance.crash.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.NpthLog;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class DefaultWorkThread extends HandlerThread {
    private static final int MAX_CRASH_TIME = 5;
    private static volatile DefaultWorkThread mInstance;
    private final Queue<CachedRunnable> mCacheQueue;
    private int mCrashTimes;
    private Handler mHandler;

    private DefaultWorkThread() {
        super("npth-worker");
        this.mCacheQueue = new ConcurrentLinkedQueue();
    }

    private static DefaultWorkThread instance() {
        if (mInstance == null) {
            synchronized (DefaultWorkThread.class) {
                if (mInstance == null) {
                    mInstance = new DefaultWorkThread();
                    mInstance.start();
                }
            }
        }
        return mInstance;
    }

    private void postCachedRunnable() {
        synchronized (this.mCacheQueue) {
            while (!this.mCacheQueue.isEmpty()) {
                CachedRunnable poll = this.mCacheQueue.poll();
                if (poll != null) {
                    try {
                        this.mHandler.sendMessageAtTime(Message.obtain(this.mHandler, poll.mRunnable), poll.mAtTimeMillis);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void updateThrowable(Throwable th) {
        try {
            int i = this.mCrashTimes;
            if (i <= 5) {
                NpthMonitor.reportInnerException(i == 5 ? "NPTH_ERR_MAX" : Constants.NPTH_CATCH, th);
            }
            this.mCrashTimes++;
        } catch (Throwable unused) {
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.mHandler = new Handler(Looper.myLooper());
        postCachedRunnable();
        while (true) {
            try {
                Looper.loop();
            } catch (Throwable th) {
                NpthLog.i(th);
                updateThrowable(th);
            }
        }
    }

    private void postInner(Runnable runnable, long j) {
        if (j < 0) {
            j = 0;
        }
        postRunnableAtTime(runnable, SystemClock.uptimeMillis() + j);
    }

    private void postRunnableAtTime(Runnable runnable, long j) {
        if (this.mHandler == null) {
            synchronized (this.mCacheQueue) {
                if (this.mHandler == null) {
                    this.mCacheQueue.add(new CachedRunnable(runnable, j));
                    return;
                }
            }
        }
        this.mHandler.sendMessageAtTime(Message.obtain(this.mHandler, runnable), j);
    }

    private void removeRunnable(Runnable runnable) {
        synchronized (this.mCacheQueue) {
            Iterator<CachedRunnable> it = this.mCacheQueue.iterator();
            while (it.hasNext()) {
                if (it.next().mRunnable.equals(runnable)) {
                    it.remove();
                }
            }
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public static void post(Runnable runnable) {
        instance().postInner(runnable, 0L);
    }

    public static void postDelayed(Runnable runnable, long j) {
        instance().postInner(runnable, j);
    }

    public static void postAtFront(Runnable runnable) {
        instance().postRunnableAtTime(runnable, 0L);
    }

    public static void removeCallbacks(Runnable runnable) {
        instance().removeRunnable(runnable);
    }

    public static Handler getHandler() {
        return instance().mHandler;
    }

    public static Thread getThread() {
        return instance();
    }

    public static boolean isCurrentThread() {
        return Thread.currentThread() == getThread();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CachedRunnable {
        long mAtTimeMillis;
        Runnable mRunnable;

        CachedRunnable(Runnable runnable, long j) {
            this.mRunnable = runnable;
            this.mAtTimeMillis = j;
        }
    }
}
