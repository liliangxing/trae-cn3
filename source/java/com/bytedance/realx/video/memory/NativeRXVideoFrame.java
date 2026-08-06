package com.bytedance.realx.video.memory;

import com.bytedance.realx.video.RXColorSpace;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.RXVideoFrameHelperInterface;
import com.bytedance.realx.video.RXVideoRotation;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NativeRXVideoFrame implements RXVideoFrameInterface {
    private long nativeHandle;
    RefObject refCounted = new RefObject(new Runnable() { // from class: com.bytedance.realx.video.memory.NativeRXVideoFrame$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            NativeRXVideoFrame.this.m809lambda$new$0$combytedancerealxvideomemoryNativeRXVideoFrame();
        }
    });

    private static native long nativeCreateRXVideoFrameFromByteMemory(long nativeByteMemoryHandle, int width, int height, RXPixelFormat pixelformat, ByteBuffer[] planeData, int[] planeLineSize, long timestampNs, ByteBuffer roiData, RXColorSpace colorSpace, RXVideoRotation rotation);

    private static native long nativeCreateRXVideoFrameFromOpenGLMemory(long nativeOpenGLMemoryHandle, long nativeVideoFrameHelperOpenGLHandle, long timestampNs, ByteBuffer roiData, RXColorSpace colorSpace, RXVideoRotation rotation);

    private static native RXColorSpace nativeGetColorSpace(long nativeHandle);

    private static native RXVideoMemoryInterface nativeGetFrameMemory(long nativeHandle);

    private static native RXVideoRotation nativeGetRotation(long nativeHandle);

    private static native ByteBuffer nativeGetSupplementData(long nativeHandle);

    private static native long nativeGetTimestampNs(long nativeHandle);

    private static native long nativeGetTimestampUs(long nativeHandle);

    private static native void nativeReleaseVideoFrame(long nativeHandle);

    private static native void nativeSetRotation(long nativeHandle, RXVideoRotation rotation);

    private static native void nativeSetTimestampNs(long nativeHandle, long timestampNs);

    private static native void nativeSetTimestampUs(long nativeHandle, long timestampUs);

    private static native NativeRXVideoFrame nativeToI420(long nativeHandle);

    public static NativeRXVideoFrame createRXVideoFrame(NativeRXByteMemory byteMemory, long timestampNs, ByteBuffer roiData, RXColorSpace colorSpace, RXVideoRotation rotation) {
        return new NativeRXVideoFrame(nativeCreateRXVideoFrameFromByteMemory(byteMemory.getNativeHandle(), byteMemory.getWidth(), byteMemory.getHeight(), byteMemory.getPixelFormat(), byteMemory.getPlaneDataArray(), byteMemory.getPlaneLineSizeArray(), timestampNs, roiData, colorSpace, rotation));
    }

    public static NativeRXVideoFrame createRXVideoFrame(NativeRXOpenGLMemory openGLMemory, RXVideoFrameHelperInterface videoFrameHelperOpenGL, long timestampNs, ByteBuffer roiData, RXColorSpace colorSpace) {
        return new NativeRXVideoFrame(nativeCreateRXVideoFrameFromOpenGLMemory(openGLMemory.getNativeHandle(), videoFrameHelperOpenGL != null ? videoFrameHelperOpenGL.getNativeHandle() : 0L, timestampNs, roiData, colorSpace, openGLMemory.getRotation()));
    }

    private NativeRXVideoFrame(long nativeHandle) {
        this.nativeHandle = nativeHandle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-bytedance-realx-video-memory-NativeRXVideoFrame, reason: not valid java name */
    public /* synthetic */ void m809lambda$new$0$combytedancerealxvideomemoryNativeRXVideoFrame() {
        long j = this.nativeHandle;
        if (j != 0) {
            nativeReleaseVideoFrame(j);
            this.nativeHandle = 0L;
        }
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface, com.bytedance.realx.base.RefCounted
    public synchronized void retain() {
        this.refCounted.retain();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface, com.bytedance.realx.base.RefCounted
    public synchronized void release() {
        this.refCounted.release();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public RXVideoMemoryInterface getAndRetainVideoFrameMemory() {
        if (isNullPointer()) {
            return null;
        }
        return nativeGetFrameMemory(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public ByteBuffer getSupplementData() {
        if (isNullPointer()) {
            return null;
        }
        return nativeGetSupplementData(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public RXColorSpace getColorSpace() {
        if (isNullPointer()) {
            return RXColorSpace.kUnknown;
        }
        return nativeGetColorSpace(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public RXVideoRotation getRotation() {
        if (isNullPointer()) {
            return RXVideoRotation.VIDEO_ROTATION_0;
        }
        return nativeGetRotation(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public void setRotation(RXVideoRotation rotation) {
        if (isNullPointer()) {
            return;
        }
        nativeSetRotation(this.nativeHandle, rotation);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public long getTimestampUs() {
        if (isNullPointer()) {
            return 0L;
        }
        return nativeGetTimestampUs(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public void setTimestampUs(long timestampUs) {
        if (isNullPointer()) {
            return;
        }
        nativeSetTimestampUs(this.nativeHandle, timestampUs);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public long getTimestampNs() {
        if (isNullPointer()) {
            return 0L;
        }
        return nativeGetTimestampNs(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public void setTimestampNs(long timestampNs) {
        if (isNullPointer()) {
            return;
        }
        nativeSetTimestampNs(this.nativeHandle, timestampNs);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public RXVideoFrameInterface toI420() {
        if (isNullPointer()) {
            return null;
        }
        return nativeToI420(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public int getWidth() {
        RXVideoMemoryInterface andRetainVideoFrameMemory = getAndRetainVideoFrameMemory();
        if (andRetainVideoFrameMemory == null) {
            return 0;
        }
        int width = andRetainVideoFrameMemory.getWidth();
        andRetainVideoFrameMemory.release();
        return width;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public int getHeight() {
        RXVideoMemoryInterface andRetainVideoFrameMemory = getAndRetainVideoFrameMemory();
        if (andRetainVideoFrameMemory == null) {
            return 0;
        }
        int height = andRetainVideoFrameMemory.getHeight();
        andRetainVideoFrameMemory.release();
        return height;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public int getRotatedWidth() {
        RXVideoMemoryInterface andRetainVideoFrameMemory = getAndRetainVideoFrameMemory();
        if (andRetainVideoFrameMemory == null) {
            return 0;
        }
        int width = andRetainVideoFrameMemory.getWidth();
        int height = andRetainVideoFrameMemory.getHeight();
        andRetainVideoFrameMemory.release();
        return getRotation().value() % 180 == 0 ? width : height;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public int getRotatedHeight() {
        RXVideoMemoryInterface andRetainVideoFrameMemory = getAndRetainVideoFrameMemory();
        if (andRetainVideoFrameMemory == null) {
            return 0;
        }
        int width = andRetainVideoFrameMemory.getWidth();
        int height = andRetainVideoFrameMemory.getHeight();
        andRetainVideoFrameMemory.release();
        return getRotation().value() % 180 == 0 ? height : width;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    protected boolean isNullPointer() {
        return this.nativeHandle == 0;
    }
}
