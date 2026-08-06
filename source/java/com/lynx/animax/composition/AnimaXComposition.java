package com.lynx.animax.composition;

import com.lynx.animax.base.CleanupReference;
import com.lynx.animax.util.AnimaXLog;

/* loaded from: classes6.dex */
public class AnimaXComposition {
    private static final String TAG = "AnimaXComposition";
    private CleanupReference mCleanUpReference;
    private long mNativePtr;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroy(long j);

    private native long nativeGetEndFrame(long j);

    private native long nativeGetStartFrame(long j);

    /* loaded from: classes6.dex */
    private static class CleanUpRunnable implements Runnable {
        private long mNativePtr;

        public CleanUpRunnable(long j) {
            this.mNativePtr = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimaXLog.i(AnimaXComposition.TAG, "nativeDestroy AnimaXComposition on CleanupReference.");
            long j = this.mNativePtr;
            if (j != 0) {
                AnimaXComposition.nativeDestroy(j);
                this.mNativePtr = 0L;
            }
        }
    }

    private AnimaXComposition(long j) {
        this.mCleanUpReference = null;
        this.mNativePtr = j;
        this.mCleanUpReference = new CleanupReference(this, new CleanUpRunnable(this.mNativePtr), true);
    }

    public static AnimaXComposition create(long j) {
        return new AnimaXComposition(j);
    }

    public long getStartFrame() {
        if (checkNativeReady()) {
            return nativeGetStartFrame(this.mNativePtr);
        }
        return 0L;
    }

    public long getEndFrame() {
        if (checkNativeReady()) {
            return nativeGetEndFrame(this.mNativePtr);
        }
        return 0L;
    }

    private boolean checkNativeReady() {
        if (this.mNativePtr != 0) {
            return true;
        }
        AnimaXLog.e(TAG, "checkNativeReady failed, nativePtr is 0");
        return false;
    }

    public long getNativePtr() {
        if (checkNativeReady()) {
            return this.mNativePtr;
        }
        return 0L;
    }

    public void release() {
        this.mCleanUpReference.cleanupNow();
        this.mNativePtr = 0L;
    }
}
