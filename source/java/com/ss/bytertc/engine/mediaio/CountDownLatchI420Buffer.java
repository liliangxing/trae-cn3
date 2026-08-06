package com.ss.bytertc.engine.mediaio;

import com.bytedance.realx.video.JavaI420Buffer;
import com.bytedance.realx.video.VideoFrame;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes7.dex */
public class CountDownLatchI420Buffer implements VideoFrame.I420Buffer {
    private final JavaI420Buffer buffer;
    private final CountDownLatch mCountDownLatch = new CountDownLatch(1);
    private Runnable mCustomReleaseCallback;

    private CountDownLatchI420Buffer(int width, int height, ByteBuffer dataY, int strideY, ByteBuffer dataU, int strideU, ByteBuffer dataV, int strideV, final Runnable customReleaseCallback) {
        this.mCustomReleaseCallback = customReleaseCallback;
        this.buffer = JavaI420Buffer.wrap(width, height, dataY, strideY, dataU, strideU, dataV, strideV, new Runnable() { // from class: com.ss.bytertc.engine.mediaio.CountDownLatchI420Buffer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CountDownLatchI420Buffer.this.m9466xd34e6daa(customReleaseCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-ss-bytertc-engine-mediaio-CountDownLatchI420Buffer, reason: not valid java name */
    public /* synthetic */ void m9466xd34e6daa(Runnable runnable) {
        this.mCountDownLatch.countDown();
        if (this.mCustomReleaseCallback != null) {
            runnable.run();
        }
    }

    public static CountDownLatchI420Buffer wrap(int width, int height, ByteBuffer dataY, int strideY, ByteBuffer dataU, int strideU, ByteBuffer dataV, int strideV, Runnable customReleaseCallback) {
        return new CountDownLatchI420Buffer(width, height, dataY, strideY, dataU, strideU, dataV, strideV, customReleaseCallback);
    }

    public CountDownLatch getLatch() {
        return this.mCountDownLatch;
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        return this.buffer.getDataY();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        return this.buffer.getDataU();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        return this.buffer.getDataV();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.buffer.getStrideY();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.buffer.getStrideU();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.buffer.getStrideV();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.buffer.getWidth();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return this.buffer.getHeight();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        return this.buffer.toI420();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        this.buffer.retain();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void release() {
        this.buffer.release();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i, int i1, int i2, int i3, int i4, int i5) {
        return this.buffer.cropAndScale(i, i1, i2, i3, i4, i5);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int i, int i1, int i2, int i3) {
        return this.buffer.scaleAndFill(i, i1, i2, i3);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return this.buffer.copyData();
    }
}
