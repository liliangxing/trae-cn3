package com.bytedance.common.wschannel.utils;

/* loaded from: classes3.dex */
public abstract class WsAsyncTask implements Runnable {
    private final long mInitialDelay;
    private boolean mIsLoop;
    private long mLoopInterval;

    public WsAsyncTask() {
        this(0L);
    }

    public WsAsyncTask(long j) {
        this(j, 0L);
    }

    public WsAsyncTask(long j, long j2) {
        this.mInitialDelay = j;
        this.mLoopInterval = j2;
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
}
