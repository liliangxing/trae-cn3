package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class NoPool implements BufferPool {
    public static final BufferPool INSTANCE = new NoPool();

    @Override // com.bytedance.compression.zstd.BufferPool
    public void release(ByteBuffer byteBuffer) {
    }

    private NoPool() {
    }

    @Override // com.bytedance.compression.zstd.BufferPool
    public ByteBuffer get(int i) {
        return ByteBuffer.allocate(i);
    }
}
