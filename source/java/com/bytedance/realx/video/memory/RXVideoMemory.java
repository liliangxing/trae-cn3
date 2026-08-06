package com.bytedance.realx.video.memory;

/* loaded from: classes4.dex */
public abstract class RXVideoMemory implements RXVideoMemoryInterface {
    protected long nativeHandle;
    RefObject refCounted = new RefObject(new Runnable() { // from class: com.bytedance.realx.video.memory.RXVideoMemory$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            RXVideoMemory.this.m7864lambda$new$0$combytedancerealxvideomemoryRXVideoMemory();
        }
    });

    private static native void nativeReleaseVideoMemory(long nativeHandle);

    /* JADX INFO: Access modifiers changed from: protected */
    public RXVideoMemory(long nativeHandle) {
        this.nativeHandle = nativeHandle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-bytedance-realx-video-memory-RXVideoMemory, reason: not valid java name */
    public /* synthetic */ void m7864lambda$new$0$combytedancerealxvideomemoryRXVideoMemory() {
        long j = this.nativeHandle;
        if (j != 0) {
            nativeReleaseVideoMemory(j);
            this.nativeHandle = 0L;
        }
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNullPointer() {
        return this.nativeHandle == 0;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface, com.bytedance.realx.base.RefCounted
    public synchronized void retain() {
        this.refCounted.retain();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface, com.bytedance.realx.base.RefCounted
    public synchronized void release() {
        this.refCounted.release();
    }
}
