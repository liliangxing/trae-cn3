package com.bytedance.frameworks.baselib.network.http.util;

/* loaded from: classes2.dex */
public abstract class AsyncTask implements Runnable {
    private final long mInitialDelay;
    private boolean mIsLoop;
    private long mLoopInterval;
    private final String mTaskIdentifier;

    public AsyncTask() {
        this(0L);
    }

    public AsyncTask(long j) {
        this(j, 0L, "");
    }

    public AsyncTask(long j, String str) {
        this(j, 0L, str);
    }

    public AsyncTask(long j, long j2, String str) {
        this.mInitialDelay = j;
        this.mLoopInterval = j2;
        this.mTaskIdentifier = str;
        if (j2 > 0) {
            this.mIsLoop = true;
        }
    }

    public final long getInitialDelay() {
        return this.mInitialDelay;
    }

    public final boolean isLoop() {
        return this.mIsLoop;
    }

    public final long getLoopInterval() {
        return this.mLoopInterval;
    }

    public final String getTaskIdentifier() {
        return this.mTaskIdentifier;
    }
}
