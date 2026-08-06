package com.ss.bytertc.engine.adapter;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes7.dex */
public class VideoSinkTask extends HandlerThread {
    private Handler mHandler;
    private Object mLock;

    public VideoSinkTask() {
        super("VideoSinkTaskManager", 0);
        this.mLock = new Object();
    }

    public void init() {
        synchronized (this.mLock) {
            try {
                try {
                    start();
                    this.mHandler = new Handler(getLooper());
                } catch (OutOfMemoryError unused) {
                    throw new IllegalStateException("videosink task create thread failed as out of memory");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void post(final Runnable runnable) {
        synchronized (this.mLock) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    public void postDelayed(final Runnable runnable, long nDelay) {
        synchronized (this.mLock) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.postDelayed(runnable, nDelay);
            }
        }
    }

    public void exit() {
        synchronized (this.mLock) {
            quitSafely();
            this.mHandler = null;
        }
    }
}
