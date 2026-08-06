package com.bytedance.realx.video;

import com.bytedance.realx.base.JniCommon;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.VideoFrame;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WrappedNativeNV12Buffer implements VideoFrame.NV12Buffer {
    private static final String TAG = "WrappedNativeNV12Buffer";
    private final ByteBuffer dataUV;
    private final ByteBuffer dataY;
    private final int height;
    private final long nativeBuffer;
    private final int strideUV;
    private final int strideY;
    private final int width;

    private static native void nativeNV12ToI420(ByteBuffer srcY, int srcStrideY, ByteBuffer srcUV, int srcStrideUV, ByteBuffer dstY, int dstStrideY, ByteBuffer dstU, int dstStrideU, ByteBuffer dstV, int dstStrideV, int width, int height);

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return null;
    }

    WrappedNativeNV12Buffer(int width, int height, ByteBuffer dataY, int strideY, ByteBuffer dataUV, int strideUV, long nativeBuffer) {
        this.width = width;
        this.height = height;
        this.dataY = dataY;
        this.strideY = strideY;
        this.dataUV = dataUV;
        this.strideUV = strideUV;
        this.nativeBuffer = nativeBuffer;
        retain();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.realx.video.VideoFrame.NV12Buffer
    public ByteBuffer getDataY() {
        return this.dataY.slice();
    }

    @Override // com.bytedance.realx.video.VideoFrame.NV12Buffer
    public ByteBuffer getDataUV() {
        return this.dataUV.slice();
    }

    @Override // com.bytedance.realx.video.VideoFrame.NV12Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // com.bytedance.realx.video.VideoFrame.NV12Buffer
    public int getStrideUV() {
        return this.strideUV;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        JavaI420Buffer allocate = JavaI420Buffer.allocate(this.width, this.height);
        if (allocate == null) {
            return null;
        }
        nativeNV12ToI420(this.dataY, this.strideY, this.dataUV, this.strideUV, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV(), this.width, this.height);
        return allocate;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.NV12Buffer toNV12() {
        retain();
        return this;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        JniCommon.nativeAddRef(this.nativeBuffer);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void release() {
        JniCommon.nativeReleaseRef(this.nativeBuffer);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight) {
        RXLogging.m283e(TAG, "cropAndScale has not been implemented, default return null");
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int dstWidth, int dstHeight, int offsetX, int offsetY) {
        RXLogging.m283e(TAG, "scaleAndFill has not been implemented, default return null");
        return null;
    }
}
