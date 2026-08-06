package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface BufferPool {
    ByteBuffer get(int i);

    void release(ByteBuffer byteBuffer);
}
