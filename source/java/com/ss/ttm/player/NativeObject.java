package com.ss.ttm.player;

/* loaded from: classes7.dex */
public class NativeObject {
    protected long mNativeObj = 0;
    protected boolean mRetain = false;

    private native void nativeRelease(long obj);

    protected void finalize() throws Throwable {
    }

    public synchronized void release() {
        if (this.mRetain) {
            long j = this.mNativeObj;
            if (j != 0) {
                nativeRelease(j);
                this.mNativeObj = 0L;
            }
        }
    }

    protected void setNativeObj(long nativeObj) {
        this.mNativeObj = nativeObj;
        this.mRetain = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWeakNativeObj(long nativeObj) {
        this.mNativeObj = nativeObj;
        this.mRetain = false;
    }

    private long getNativeObj() {
        return this.mNativeObj;
    }
}
