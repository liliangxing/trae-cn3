package com.bytedance.sysoptimizer.javahook;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class ProxyDisplayListenerDelegate {
    private static final String TAG = "ProxyDisplayListenerDelegate";

    public ProxyDisplayListenerDelegate(DisplayManager.DisplayListener displayListener, Looper looper, long j) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_DISPLAYLISTENERDELEGATE_INIT, this, displayListener, looper, Long.valueOf(j));
        AHook.getCallback().e(TAG, "ProxyDisplayListenerDelegate() called with: listener = [" + displayListener + "], looper = [" + looper + "], eventsMask = [" + j + "]", new Throwable());
        if (looper != null && Looper.getMainLooper() != looper) {
            throw new IllegalStateException();
        }
    }

    public ProxyDisplayListenerDelegate(DisplayManager.DisplayListener displayListener, Looper looper) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_DISPLAYLISTENERDELEGATE_INIT_1, this, displayListener, looper);
        AHook.getCallback().e(TAG, "ProxyDisplayListenerDelegate() called with: listener = [" + displayListener + "], looper = [" + looper + "]", new Throwable());
        if (looper != null && Looper.getMainLooper() != looper) {
            throw new IllegalStateException();
        }
    }

    public ProxyDisplayListenerDelegate(DisplayManager.DisplayListener displayListener, Executor executor, long j) throws Throwable {
        Object readField;
        AHook.callOrigin(OriginMethodKey.KEY_DISPLAYLISTENERDELEGATE_INIT_2, this, displayListener, executor, Long.valueOf(j));
        AHook.getCallback().e(TAG, "ProxyDisplayListenerDelegate() called with: listener = [" + displayListener + "], executor = [" + executor + "], eventsMask = [" + j + "]", new Throwable());
        if (executor != null && executor.getClass().getName().equals("android.os.HandlerExecutor") && (readField = DoubleReflectUtils.readField(executor, "mHandler")) != null && ((Handler) readField).getLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException();
        }
    }
}
