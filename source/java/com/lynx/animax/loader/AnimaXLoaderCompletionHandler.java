package com.lynx.animax.loader;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class AnimaXLoaderCompletionHandler implements IAnimaXLoaderCompletionHandler {
    private final AtomicBoolean mCompleted = new AtomicBoolean(false);
    private final long mNativePtr;

    public native void nativeOnComplete(long j, AnimaXLoaderResponseNativeAdapter animaXLoaderResponseNativeAdapter);

    public AnimaXLoaderCompletionHandler(long j) {
        this.mNativePtr = j;
    }

    public static AnimaXLoaderCompletionHandler createCompletionHandler(long j) {
        return new AnimaXLoaderCompletionHandler(j);
    }

    @Override // com.lynx.animax.loader.IAnimaXLoaderCompletionHandler
    public void onComplete(AnimaXLoaderResponse<?> animaXLoaderResponse) {
        if (this.mCompleted.getAndSet(true)) {
            return;
        }
        nativeOnComplete(this.mNativePtr, AnimaXLoaderResponseNativeAdapter.create(animaXLoaderResponse));
    }
}
