package com.bytedance.realx.video.agfx;

/* loaded from: classes4.dex */
public class RXGPUCacheCtrl {
    private static RXGPUCacheCtrl instance;
    private long nativeHandle;

    private static native void nativeBind(long nativeHandle);

    private static native RXGPUCacheCtrl nativeGetInstance();

    private static native void nativeUnBind(long nativeHandle);

    public static RXGPUCacheCtrl getInstance() {
        RXGPUCacheCtrl nativeGetInstance = nativeGetInstance();
        instance = nativeGetInstance;
        return nativeGetInstance;
    }

    private RXGPUCacheCtrl(long nativeHandle) {
        this.nativeHandle = nativeHandle;
    }

    public void bind() {
        nativeBind(this.nativeHandle);
    }

    public void unbind() {
        nativeUnBind(this.nativeHandle);
    }
}
