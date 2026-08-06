package com.lynx.animax;

import android.view.Choreographer;

/* loaded from: classes6.dex */
public class VSyncMonitor {
    private static native void nativeInvokeCallback(long j, long j2);

    public static void requestVSync(final long j) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.lynx.animax.VSyncMonitor.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                VSyncMonitor.invokeNativeCallback(j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void invokeNativeCallback(long j, long j2) {
        nativeInvokeCallback(j, j2);
    }
}
