package com.bytedance.realx.base;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class JniCommon {
    public static native void nativeAddRef(long refCountedPointer);

    public static native ByteBuffer nativeAllocateByteBuffer(int size);

    public static native void nativeFreeByteBuffer(ByteBuffer buffer);

    public static native void nativeReleaseRef(long refCountedPointer);
}
