package com.bytedance.sysoptimizer.anr;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;

/* loaded from: classes5.dex */
public class AnrMonitor extends Thread {
    private static final int ANR_RESTORE_TIME = 60000;
    public static final int STUCK_1S = 1;
    public static final int STUCK_2S = 2;
    public static final int STUCK_3S = 3;
    public static final int STUCK_4S = 4;
    public static final int STUCK_5S = 5;
    private static final String TAG = "InputAnrOpt";
    private static AnrMonitor sAnrMonitor;
    private final HandlerChecker mHandlerChecker;
    private int mLooperWaitMs = 1000;
    private long mStartTime = 0;
    private boolean mLastStatus = false;
    private boolean mPaused = false;
    private boolean mThreadStart = false;
    private int mNewAnrTimeOutMs = 80000;
    private final int ANR_TIMEOUT = 2000;
    private final Object mLock = new Object();
    private long mFirstStuckTime = 0;

    private AnrMonitor() {
        HandlerChecker handlerChecker = new HandlerChecker(new Handler(Looper.getMainLooper()));
        this.mHandlerChecker = handlerChecker;
        handlerChecker.scheduleCheckLocked();
    }

    public static AnrMonitor getInstance() {
        if (sAnrMonitor == null) {
            synchronized (AnrMonitor.class) {
                if (sAnrMonitor == null) {
                    sAnrMonitor = new AnrMonitor();
                }
            }
        }
        return sAnrMonitor;
    }

    public void pauseThread() {
        synchronized (this.mLock) {
            this.mPaused = true;
        }
        Log.d(TAG, "pauseThread");
    }

    public void resumeThread() {
        synchronized (this.mLock) {
            this.mPaused = false;
            notifyAll();
            Log.d(TAG, "resumeThread");
        }
    }

    public void anrOptStart(int i, int i2) {
        synchronized (this) {
            if (!this.mThreadStart) {
                this.mPaused = false;
                this.mThreadStart = true;
                if (this.mNewAnrTimeOutMs > 2000) {
                    this.mNewAnrTimeOutMs = i;
                }
                if (i2 > 0 && i2 < 2000) {
                    this.mLooperWaitMs = i2;
                }
                setName("AnrOptThread");
                start();
                Log.d(TAG, "startThread");
            } else {
                resumeThread();
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class HandlerChecker implements Runnable {
        private volatile boolean mCompleted = true;
        private final Handler mHandler;

        HandlerChecker(Handler handler) {
            this.mHandler = handler;
        }

        public void scheduleCheckLocked() {
            if (this.mCompleted) {
                AnrMonitor.this.mStartTime = SystemClock.uptimeMillis();
                this.mCompleted = false;
                this.mHandler.postAtFrontOfQueue(this);
            }
        }

        public boolean isOverdueLocked() {
            return !this.mCompleted && SystemClock.uptimeMillis() >= AnrMonitor.this.mStartTime + ((long) AnrMonitor.this.mLooperWaitMs);
        }

        public Thread getThread() {
            return this.mHandler.getLooper().getThread();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mCompleted = true;
        }
    }

    private boolean needNotify() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis < this.mNewAnrTimeOutMs) {
            Log.d(TAG, "mNewAnrTimeOutMs:" + this.mNewAnrTimeOutMs + ", stuckMs:" + uptimeMillis + " ms");
            return true;
        }
        Log.d(TAG, "It's stuck for too long and I need ANR");
        return false;
    }

    private boolean isAnrRestore(int i) {
        return i * this.mLooperWaitMs > 60000;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Log.d(TAG, "ANR monitor run...");
        Process.setThreadPriority(-2);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            synchronized (this) {
                if (this.mPaused) {
                    try {
                        wait();
                        Log.d(TAG, "ANR monitor continue");
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.mHandlerChecker.scheduleCheckLocked();
                try {
                    wait(this.mLooperWaitMs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.mHandlerChecker.isOverdueLocked()) {
                    if (needNotify()) {
                        if (i2 == 0) {
                            this.mFirstStuckTime = System.currentTimeMillis();
                        } else if (i2 >= 1 && i2 != (System.currentTimeMillis() - this.mFirstStuckTime) / this.mLooperWaitMs) {
                            this.mFirstStuckTime = System.currentTimeMillis();
                            i2 = 0;
                        }
                        i3++;
                        i2++;
                        Log.d(TAG, "ANR coming..., anr level:" + i3 + ", newAnrLevel:" + i2);
                        AnrManager.getInstance().onAnrChange(true, i3, i2);
                        this.mLastStatus = true;
                    }
                    i = 0;
                } else {
                    i++;
                    if (this.mLastStatus && isAnrRestore(i)) {
                        Log.d(TAG, "ANR restore..., anr level:0");
                        AnrManager.getInstance().onAnrChange(false, 0, 0);
                        this.mLastStatus = false;
                        i = 0;
                        i3 = 0;
                    }
                }
            }
        }
    }
}
