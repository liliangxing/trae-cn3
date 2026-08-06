package com.bytedance.realx.base;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class RefCountDelegate implements RefCounted {
    private final AtomicInteger refCount = new AtomicInteger(1);
    private final Runnable releaseCallback;

    public RefCountDelegate(Runnable releaseCallback) {
        this.releaseCallback = releaseCallback;
    }

    @Override // com.bytedance.realx.base.RefCounted
    public void retain() {
        this.refCount.incrementAndGet();
    }

    @Override // com.bytedance.realx.base.RefCounted
    public void release() {
        Runnable runnable;
        if (this.refCount.decrementAndGet() != 0 || (runnable = this.releaseCallback) == null) {
            return;
        }
        runnable.run();
    }
}
