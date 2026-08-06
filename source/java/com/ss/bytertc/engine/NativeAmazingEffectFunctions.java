package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class NativeAmazingEffectFunctions {
    public static native int nativeAppendAmazingEffectNodes(long amazingEffectPtr, String[] effectNodes);

    public static native String nativeGetEffectSDKVersion();

    public static native int nativeRemoveAmazingEffectNodes(long amazingEffectPtr, String[] effectNodes);

    public static native int nativeReplaceAmazingEffectNodes(long amazingEffectPtr, String[] oldEffectNodes, String[] newEffectNodes);

    public static native int nativeSetAmazingEffectNodes(long amazingEffectPtr, String[] effectNodes);

    public static native void nativeSetVirtualBackgroundFilePath(long amazingEffectPtr, String path, int id);

    public static native int nativeUpdateAmazingEffectNode(long amazingEffectPtr, String effectNode, String key, float value);
}
