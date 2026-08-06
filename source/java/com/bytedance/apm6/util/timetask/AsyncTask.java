package com.bytedance.apm6.util.timetask;

/* loaded from: classes3.dex */
public abstract class AsyncTask implements Runnable {
    private long mInitialDelay;
    private boolean mIsLoop;
    private long mLoopInterval;

    public AsyncTask() {
        this(0L);
    }

    public AsyncTask(long j) {
        this(j, 0L);
    }

    public AsyncTask(long j, long j2) {
        this.mInitialDelay = j;
        this.mLoopInterval = j2;
        if (j2 > 0) {
            this.mIsLoop = true;
        }
    }

    public long getInitialDelay() {
        return this.mInitialDelay;
    }

    public final boolean isLoop() {
        return this.mIsLoop;
    }

    public final long getLoopInterval() {
        return this.mLoopInterval;
    }

    public void refresh(long j, long j2) {
        this.mInitialDelay = j;
        this.mLoopInterval = j2;
        if (j2 > 0) {
            this.mIsLoop = true;
        }
    }
}
