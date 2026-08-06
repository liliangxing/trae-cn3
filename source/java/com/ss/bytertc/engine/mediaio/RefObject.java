package com.ss.bytertc.engine.mediaio;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class RefObject {
    private final AtomicInteger refCount = new AtomicInteger(1);
    private final Runnable releaseCallback;

    public RefObject(Runnable releaseCallback) {
        this.releaseCallback = releaseCallback;
    }

    public void retain() {
        this.refCount.incrementAndGet();
    }

    public void release() {
        Runnable runnable;
        if (this.refCount.decrementAndGet() != 0 || (runnable = this.releaseCallback) == null) {
            return;
        }
        runnable.run();
    }

    public boolean hasReleaseCallback() {
        return this.releaseCallback != null;
    }
}
