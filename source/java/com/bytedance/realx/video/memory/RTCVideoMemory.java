package com.bytedance.realx.video.memory;

import com.bytedance.realx.base.RefCounted;
import com.bytedance.realx.video.RXVideoMemoryType;
import com.bytedance.realx.video.RXVideoRotation;

/* loaded from: classes4.dex */
public abstract class RTCVideoMemory implements RefCounted {
    private Runnable releaseCallback = null;
    RefObject refCounted = new RefObject(new Runnable() { // from class: com.bytedance.realx.video.memory.RTCVideoMemory$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            RTCVideoMemory.this.m7863lambda$new$0$combytedancerealxvideomemoryRTCVideoMemory();
        }
    });

    public abstract int getHeight();

    public abstract RXVideoMemoryType getMemoryType();

    public abstract RXVideoRotation getRotation();

    public abstract int getWidth();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-bytedance-realx-video-memory-RTCVideoMemory, reason: not valid java name */
    public /* synthetic */ void m7863lambda$new$0$combytedancerealxvideomemoryRTCVideoMemory() {
        Runnable runnable = this.releaseCallback;
        if (runnable != null) {
            runnable.run();
        }
    }

    public synchronized void setReleaseCallback(Runnable releaseCallback) {
        this.releaseCallback = releaseCallback;
    }

    public synchronized boolean hasReleaseCallback() {
        return this.releaseCallback != null;
    }

    @Override // com.bytedance.realx.base.RefCounted
    public synchronized void retain() {
        this.refCounted.retain();
    }

    @Override // com.bytedance.realx.base.RefCounted
    public synchronized void release() {
        this.refCounted.release();
    }
}
