package com.bytedance.realx.video;

import com.bytedance.realx.base.JniCommon;
import com.bytedance.realx.base.RefCountDelegate;
import com.bytedance.realx.video.VideoFrame;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes4.dex */
public class JavaI420Buffer implements VideoFrame.I420Buffer {
    private final ByteBuffer dataU;
    private final ByteBuffer dataV;
    private final ByteBuffer dataY;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int strideU;
    private final int strideV;
    private final int strideY;
    private final int width;

    private static native void nativeCropAndScaleI420(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, int cropX, int cropY, int cropWidth, int cropHeight, ByteBuffer dstY, int dstStrideY, ByteBuffer dstU, int dstStrideU, ByteBuffer dstV, int dstStrideV, int scaleWidth, int scaleHeight);

    private static native void nativeScaleAndFillI420(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, int srcWidth, int srcHeight, ByteBuffer dstY, int dstStrideY, ByteBuffer dstU, int dstStrideU, ByteBuffer dstV, int dstStrideV, int dstWidth, int dstHeight, int offsetX, int offsetY);

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return null;
    }

    private JavaI420Buffer(int width, int height, ByteBuffer dataY, int strideY, ByteBuffer dataU, int strideU, ByteBuffer dataV, int strideV, Runnable releaseCallback) {
        this.width = width;
        this.height = height;
        this.dataY = dataY;
        this.dataU = dataU;
        this.dataV = dataV;
        this.strideY = strideY;
        this.strideU = strideU;
        this.strideV = strideV;
        this.refCountDelegate = new RefCountDelegate(releaseCallback);
    }

    private static void checkCapacity(ByteBuffer data, int width, int height, int stride) {
        int i = (stride * (height - 1)) + width;
        if (data.capacity() < i) {
            throw new IllegalArgumentException("Buffer must be at least " + i + " bytes, but was " + data.capacity());
        }
    }

    public static JavaI420Buffer wrap(int width, int height, ByteBuffer dataY, int strideY, ByteBuffer dataU, int strideU, ByteBuffer dataV, int strideV, Runnable releaseCallback) {
        if (dataY == null || dataU == null || dataV == null) {
            throw new IllegalArgumentException("Data buffers cannot be null.");
        }
        if (!dataY.isDirect() || !dataU.isDirect() || !dataV.isDirect()) {
            throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
        }
        ByteBuffer slice = dataY.slice();
        ByteBuffer slice2 = dataU.slice();
        ByteBuffer slice3 = dataV.slice();
        int i = (width + 1) / 2;
        int i2 = height / 2;
        checkCapacity(slice, width, height, strideY);
        checkCapacity(slice2, i, i2, strideU);
        checkCapacity(slice3, i, i2, strideV);
        return new JavaI420Buffer(width, height, slice, strideY, slice2, strideU, slice3, strideV, releaseCallback);
    }

    public static JavaI420Buffer allocate(int width, int height) {
        int i = (height + 1) / 2;
        int i2 = (width + 1) / 2;
        int i3 = width * height;
        int i4 = i3 + 0;
        int i5 = i2 * i;
        int i6 = i4 + i5;
        final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i3 + (i2 * 2 * i));
        if (nativeAllocateByteBuffer == null) {
            return null;
        }
        nativeAllocateByteBuffer.position(0);
        nativeAllocateByteBuffer.limit(i4);
        ByteBuffer slice = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i4);
        nativeAllocateByteBuffer.limit(i6);
        ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i6);
        nativeAllocateByteBuffer.limit(i6 + i5);
        return new JavaI420Buffer(width, height, slice, width, slice2, i2, nativeAllocateByteBuffer.slice(), i2, new Runnable() { // from class: com.bytedance.realx.video.JavaI420Buffer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }

    public static JavaI420Buffer allocate(int width, int height, int stride, int sliceHeight) {
        int i = stride / 2;
        int i2 = stride * sliceHeight;
        int i3 = i2 + 0;
        int i4 = i * sliceHeight;
        int i5 = (i4 / 2) + i3;
        final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i2 + (i * 2 * sliceHeight));
        if (nativeAllocateByteBuffer == null) {
            return null;
        }
        nativeAllocateByteBuffer.position(0);
        nativeAllocateByteBuffer.limit(i3);
        ByteBuffer slice = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i3);
        nativeAllocateByteBuffer.limit(i5);
        ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i5);
        nativeAllocateByteBuffer.limit(i5 + i4);
        return new JavaI420Buffer(width, height, slice, stride, slice2, i, nativeAllocateByteBuffer.slice(), i, new Runnable() { // from class: com.bytedance.realx.video.JavaI420Buffer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        return this.dataY.slice();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        return this.dataU.slice();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        return this.dataV.slice();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.strideU;
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.strideV;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        retain();
        return this;
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
    public VideoFrame.Buffer cropAndScale(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight) {
        return cropAndScaleI420(this, cropX, cropY, cropWidth, cropHeight, scaleWidth, scaleHeight);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int dstWidth, int dstHeight, int offsetX, int offsetY) {
        return scaleAndFillI420(this, dstWidth, dstHeight, offsetX, offsetY);
    }

    public static VideoFrame.Buffer cropAndScaleI420(final VideoFrame.I420Buffer buffer, int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight) {
        if (cropWidth == scaleWidth && cropHeight == scaleHeight) {
            ByteBuffer dataY = buffer.getDataY();
            ByteBuffer dataU = buffer.getDataU();
            ByteBuffer dataV = buffer.getDataV();
            dataY.position(cropX + (buffer.getStrideY() * cropY));
            int i = cropX / 2;
            int i2 = cropY / 2;
            dataU.position((buffer.getStrideU() * i2) + i);
            dataV.position(i + (i2 * buffer.getStrideV()));
            buffer.retain();
            ByteBuffer slice = dataY.slice();
            int strideY = buffer.getStrideY();
            ByteBuffer slice2 = dataU.slice();
            int strideU = buffer.getStrideU();
            ByteBuffer slice3 = dataV.slice();
            int strideV = buffer.getStrideV();
            Objects.requireNonNull(buffer);
            return wrap(scaleWidth, scaleHeight, slice, strideY, slice2, strideU, slice3, strideV, new Runnable() { // from class: com.bytedance.realx.video.JavaI420Buffer$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFrame.I420Buffer.this.release();
                }
            });
        }
        JavaI420Buffer allocate = allocate(scaleWidth, scaleHeight);
        if (allocate == null) {
            return null;
        }
        nativeCropAndScaleI420(buffer.getDataY(), buffer.getStrideY(), buffer.getDataU(), buffer.getStrideU(), buffer.getDataV(), buffer.getStrideV(), cropX, cropY, cropWidth, cropHeight, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV(), scaleWidth, scaleHeight);
        return allocate;
    }

    public static VideoFrame.Buffer scaleAndFillI420(final VideoFrame.I420Buffer buffer, int dstWidth, int dstHeight, int offsetX, int offsetY) {
        JavaI420Buffer allocate = allocate(dstWidth, dstHeight);
        if (allocate == null) {
            return null;
        }
        nativeScaleAndFillI420(buffer.getDataY(), buffer.getStrideY(), buffer.getDataU(), buffer.getStrideU(), buffer.getDataV(), buffer.getStrideV(), buffer.getWidth(), buffer.getHeight(), allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV(), dstWidth, dstHeight, offsetX, offsetY);
        return allocate;
    }
}
