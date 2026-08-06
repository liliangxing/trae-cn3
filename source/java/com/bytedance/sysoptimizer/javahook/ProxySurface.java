package com.bytedance.sysoptimizer.javahook;

import android.graphics.SurfaceTexture;
import android.view.SurfaceControl;

/* loaded from: classes5.dex */
public class ProxySurface {
    private static final String TAG = "ProxySurface";

    public ProxySurface() throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_SURFACE_INIT, this, new Object[0]);
        AHook.getCallback().e(TAG, "ProxySurface() called", new Throwable());
    }

    public ProxySurface(long j) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_SURFACE_INIT_1, this, Long.valueOf(j));
        AHook.getCallback().e(TAG, "ProxySurface() called with: nativeObject = [" + Long.toHexString(j) + "]", new Throwable());
    }

    public ProxySurface(SurfaceTexture surfaceTexture) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_SURFACE_INIT_2, this, surfaceTexture);
        AHook.getCallback().e(TAG, "ProxySurface() called with: surfaceTexture = [" + surfaceTexture + "]", new Throwable());
    }

    public ProxySurface(SurfaceControl surfaceControl) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_SURFACE_INIT_3, this, surfaceControl);
        AHook.getCallback().e(TAG, "ProxySurface() called with: from = [" + surfaceControl + "]", new Throwable());
    }
}
