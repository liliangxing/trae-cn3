package com.bytedance.frameworks.baselib.network.dispatcher;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public abstract class IApiTask implements IRequest, Runnable, Comparable<IRequest> {
    protected int mSequence;
    protected final AtomicBoolean mStarted = new AtomicBoolean(false);
    protected final AtomicBoolean mCanceled = new AtomicBoolean(false);
    protected int mDelayTime = 0;

    public boolean needTryLocal() {
        return false;
    }

    @Deprecated
    public boolean run4Local() {
        return false;
    }

    public void cancel() {
        this.mCanceled.compareAndSet(false, true);
    }

    public boolean isCanceled() {
        return this.mCanceled.get();
    }

    public IApiTask setSequence(int i) {
        this.mSequence = i;
        return this;
    }

    public int getDelayTime() {
        return this.mDelayTime;
    }
}
