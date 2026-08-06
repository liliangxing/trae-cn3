package com.lynx.tasm;

import com.lynx.tasm.base.LLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class LynxWhiteBoard {
    public static final String TAG = "LynxWhiteBoard";
    private long mPtr;

    private native long nativeCreate();

    private native void nativeDestroy(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxWhiteBoard() {
        this.mPtr = 0L;
        if (LynxEnv.inst().isNativeLibraryLoaded()) {
            this.mPtr = nativeCreate();
        } else {
            LLog.m2577e(TAG, "LynxWhiteBoard create failed, since LynxEnv init failed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getPtr() {
        return this.mPtr;
    }

    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            nativeDestroy(j);
            this.mPtr = 0L;
        }
    }
}
