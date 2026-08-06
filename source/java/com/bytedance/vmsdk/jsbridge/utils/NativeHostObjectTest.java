package com.bytedance.vmsdk.jsbridge.utils;

/* loaded from: classes6.dex */
public class NativeHostObjectTest implements NativeHostObject {
    native long nativeGetHostObject(long j);

    @Override // com.bytedance.vmsdk.jsbridge.utils.NativeHostObject
    public long getPtr(long j) {
        return nativeGetHostObject(j);
    }
}
