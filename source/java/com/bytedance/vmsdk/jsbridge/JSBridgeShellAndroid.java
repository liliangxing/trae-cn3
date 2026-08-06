package com.bytedance.vmsdk.jsbridge;

/* loaded from: classes6.dex */
public class JSBridgeShellAndroid {
    private long mNativePtr;

    private static native long nativeCreateShellAndroid(JSModuleManager jSModuleManager);

    private static native void nativeEvaluateJS(long j, String str);

    public void init(JSModuleManager jSModuleManager) {
        this.mNativePtr = nativeCreateShellAndroid(jSModuleManager);
    }

    public void evaluateJS(String str) {
        nativeEvaluateJS(this.mNativePtr, str);
    }
}
