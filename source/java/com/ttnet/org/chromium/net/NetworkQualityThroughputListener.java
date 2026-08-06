package com.ttnet.org.chromium.net;

import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public abstract class NetworkQualityThroughputListener {
    private final Executor mExecutor;

    public abstract void onThroughputObservation(int i, long j, int i2);

    public NetworkQualityThroughputListener(Executor executor) {
        if (executor == null) {
            throw new IllegalStateException("Executor must not be null");
        }
        this.mExecutor = executor;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }
}
