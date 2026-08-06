package com.bytedance.realx.video;

import com.bytedance.realx.base.RefCountDelegate;
import com.bytedance.realx.video.VideoFrame;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public abstract class RGBABuffer implements VideoFrame.Buffer {
    protected ByteBuffer buffer_;
    protected int height_;
    protected RefCountDelegate refCountDelegate;
    protected int stride_;
    protected int width_;

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int x, int y, int w, int h, int sw, int sh) {
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getBufferType() {
        return 5;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int w, int h, int x, int y) {
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        return null;
    }

    public int getStride() {
        return this.stride_;
    }

    public ByteBuffer getBuffer() {
        return this.buffer_;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.width_;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return this.height_;
    }
}
