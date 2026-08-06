package com.bytedance.sysoptimizer.javahook;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes5.dex */
public class ProxyDisplayManager {
    private static final String TAG = "ProxyDisplayManager";

    public void registerDisplayListener(DisplayManager.DisplayListener displayListener, Handler handler) throws Throwable {
        AHook.getCallback().e(TAG, "registerDisplayListener() called with: listener = [" + displayListener + "], handler = [" + handler + "]", new Throwable());
        if (handler != null) {
            Looper.getMainLooper();
            handler.getLooper();
        }
        AHook.callOrigin(OriginMethodKey.KEY_DISPLAYMANAGER_REGISTERDISPLAYLISTENER, this, displayListener, handler);
    }
}
