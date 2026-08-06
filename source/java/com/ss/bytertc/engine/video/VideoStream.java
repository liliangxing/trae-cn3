package com.ss.bytertc.engine.video;

import com.bytedance.realx.base.RefCounted;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class VideoStream implements RefCounted {
    private final Buffer buffer;
    private final int height;
    private final int width;

    /* loaded from: classes7.dex */
    public interface Buffer extends RefCounted {
        ByteBuffer getData();

        int getDataSize();

        @Override // com.bytedance.realx.base.RefCounted
        void release();

        @Override // com.bytedance.realx.base.RefCounted
        void retain();
    }

    public VideoStream(Buffer buffer, int width, int height) {
        this.buffer = buffer;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Buffer getBuffer() {
        return this.buffer;
    }

    public static ByteBuffer allocateDirectByteBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity);
    }

    @Override // com.bytedance.realx.base.RefCounted
    public void retain() {
        this.buffer.retain();
    }

    @Override // com.bytedance.realx.base.RefCounted
    public void release() {
        this.buffer.release();
    }
}
