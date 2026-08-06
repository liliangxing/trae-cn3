package com.bytedance.frameworks.baselib.network.asynctask;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class NetworkAsyncTask implements Runnable {
    private long mInitialDelay;
    private long mLoopInterval;
    private NetworkAsyncTaskType mTaskType;
    private TimeUnit mTimeUnit;

    public NetworkAsyncTask() {
        this.mInitialDelay = 0L;
        this.mLoopInterval = 0L;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
    }

    public NetworkAsyncTask(long j) {
        this.mInitialDelay = 0L;
        this.mLoopInterval = 0L;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
        this.mLoopInterval = j;
    }

    public NetworkAsyncTask(long j, long j2) {
        this(j2);
        this.mInitialDelay = j;
    }

    public NetworkAsyncTask(long j, long j2, TimeUnit timeUnit) {
        this(j, j2);
        this.mTimeUnit = timeUnit;
    }

    public boolean isLoop() {
        return this.mLoopInterval > 0;
    }

    public long getInitialDelay() {
        return this.mInitialDelay;
    }

    public long getLoopInterval() {
        return this.mLoopInterval;
    }

    public TimeUnit getTimeUnit() {
        return this.mTimeUnit;
    }

    public void setTaskType(NetworkAsyncTaskType networkAsyncTaskType) {
        this.mTaskType = networkAsyncTaskType;
    }

    public NetworkAsyncTaskType getTaskType() {
        return this.mTaskType;
    }
}
