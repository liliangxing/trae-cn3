package com.ss.ttm.player;

import java.nio.ByteBuffer;

/* compiled from: DirectBufferPool.java */
/* loaded from: classes7.dex */
class DirectBufferUnion {
    ByteBuffer buffer;
    long freeTimePoint;
    int size;

    public DirectBufferUnion(ByteBuffer buffer, int size) {
        this.buffer = buffer;
        this.size = size;
    }

    public void resetFreeTimePoint() {
        this.freeTimePoint = System.currentTimeMillis();
    }
}
