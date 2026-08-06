package com.bytedance.crash.nativecrash;

import com.bytedance.crash.jni.NativeBridge;

@Deprecated
/* loaded from: classes3.dex */
public class NativeImpl {
    public static void doStartReRegisterNative() {
        NativeBridge.doSignalRecover();
    }
}
