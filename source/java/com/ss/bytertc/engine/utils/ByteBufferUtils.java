package com.ss.bytertc.engine.utils;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class ByteBufferUtils {
    public static native ByteBuffer nativeAllocateBuffer(int size);

    public static native int nativeRGBAToI420(ByteBuffer bufferRGBA, int strideRGBA, ByteBuffer bufferY, int strideY, ByteBuffer bufferU, int strideU, ByteBuffer bufferV, int strideV, int width, int height);

    public static native void nativeReleaseBuffer(ByteBuffer buffer);
}
