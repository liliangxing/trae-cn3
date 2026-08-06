package com.ss.bytertc.engine.video;

import com.bytedance.realx.base.JniCommon;
import com.ss.bytertc.engine.video.VideoStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
class WrappedNativeStreamBuffer implements VideoStream.Buffer {
    private final ByteBuffer data;
    private final long nativeBuffer;
    private final int size;

    WrappedNativeStreamBuffer(int size, ByteBuffer data, long nativeBuffer) {
        this.size = size;
        this.data = data;
        this.nativeBuffer = nativeBuffer;
        retain();
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer
    public int getDataSize() {
        return this.size;
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer
    public ByteBuffer getData() {
        return this.data.slice();
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        JniCommon.nativeAddRef(this.nativeBuffer);
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer, com.bytedance.realx.base.RefCounted
    public void release() {
        JniCommon.nativeReleaseRef(this.nativeBuffer);
    }
}
