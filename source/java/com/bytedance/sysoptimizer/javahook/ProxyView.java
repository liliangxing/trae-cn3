package com.bytedance.sysoptimizer.javahook;

import android.graphics.Matrix;
import android.os.Looper;

/* loaded from: classes5.dex */
public class ProxyView {
    private static final String TAG = "ProxyView";

    public Matrix getMatrix() throws Throwable {
        AHook.getCallback().e(TAG, "getMatrix() called", new Throwable());
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            AHook.getCallback().e(TAG, "getMatrix() called in sub thread", new Throwable());
        }
        return (Matrix) AHook.callOrigin(OriginMethodKey.KEY_VIEW_GETMATRIX, this, new Object[0]);
    }
}
