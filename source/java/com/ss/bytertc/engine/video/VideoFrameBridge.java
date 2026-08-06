package com.ss.bytertc.engine.video;

import android.opengl.EGLContext;
import com.ss.bytertc.engine.data.CameraId;
import com.ss.bytertc.engine.data.VideoBufferType;
import com.ss.bytertc.engine.data.VideoContentType;
import com.ss.bytertc.engine.data.VideoFrameData;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.data.VideoRotation;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class VideoFrameBridge implements IVideoFrame {
    private CameraId mCameraId;
    private long mCaptureTimeStamp;
    private long mNativePtr;
    private final AtomicInteger mRefCount;
    private VideoFrameData mVfd;

    public static native void nativeAddRef(long nativePtr);

    public static native long nativeCreateIVideoFrame(IVideoFrame vf, int bufferType, int pixelFormat, int contentType, int width, int height, int rotation, int numberOfPlanes, ByteBuffer[] planeArray, int[] strideArray, ByteBuffer seiData, int textureId, float[] textureMatrix, EGLContext eglCtx, int cameraId);

    public static native long nativeCreateVideoFrameData(int bufferType, int pixelFormat, int contentType, int width, int height, int rotation, long timestampUs, int numberOfPlanes, ByteBuffer[] planeArray, int[] strideArray, ByteBuffer seiData, ByteBuffer roiData, int textureId, float[] textureMatrix, EGLContext eglCtx);

    public static native long nativeReleaseRef(long nativePtr);

    VideoFrameBridge(long nativePtr, int bufferType, int pixelFormat, int contentType, int width, int height, int rotation, long timestampUs, int numberOfPlanes, ByteBuffer[] planeArray, int[] strideArray, ByteBuffer seiData, int textureId, float[] textureMatrix, EGLContext eglCtxHandle, FovVideoFrameInfo fovInfo, int cameraId) {
        this.mNativePtr = 0L;
        this.mVfd = null;
        this.mCameraId = CameraId.CAMERA_ID_FRONT;
        this.mRefCount = new AtomicInteger(1);
        this.mCaptureTimeStamp = 0L;
        this.mNativePtr = nativePtr;
        VideoFrameData videoFrameData = new VideoFrameData();
        this.mVfd = videoFrameData;
        videoFrameData.bufferType = VideoBufferType.fromId(bufferType);
        this.mVfd.pixelFormat = VideoPixelFormat.fromId(pixelFormat);
        this.mVfd.contentType = VideoContentType.fromId(contentType);
        this.mVfd.width = width;
        this.mVfd.height = height;
        this.mVfd.rotation = VideoRotation.fromId(rotation);
        this.mVfd.timestampUs = timestampUs;
        this.mVfd.numberOfPlanes = numberOfPlanes;
        this.mVfd.planeData = planeArray;
        this.mVfd.planeStride = strideArray;
        this.mVfd.seiData = seiData;
        this.mVfd.textureId = textureId;
        this.mVfd.textureMatrix = textureMatrix;
        this.mVfd.eglContext = eglCtxHandle;
        this.mVfd.fovTileInfo = fovInfo;
        this.mCameraId = CameraId.fromId(cameraId);
        nativeAddRef(this.mNativePtr);
    }

    VideoFrameBridge(long nativePtr, int bufferType, int pixelFormat, int contentType, int width, int height, int rotation, long timestampUs, long captureTimestampUs, int numberOfPlanes, ByteBuffer[] planeArray, int[] strideArray, ByteBuffer seiData, int textureId, float[] textureMatrix, EGLContext eglCtxHandle, FovVideoFrameInfo fovInfo, int cameraId) {
        this.mNativePtr = 0L;
        this.mVfd = null;
        this.mCameraId = CameraId.CAMERA_ID_FRONT;
        this.mRefCount = new AtomicInteger(1);
        this.mCaptureTimeStamp = 0L;
        this.mNativePtr = nativePtr;
        VideoFrameData videoFrameData = new VideoFrameData();
        this.mVfd = videoFrameData;
        videoFrameData.bufferType = VideoBufferType.fromId(bufferType);
        this.mVfd.pixelFormat = VideoPixelFormat.fromId(pixelFormat);
        this.mVfd.contentType = VideoContentType.fromId(contentType);
        this.mVfd.width = width;
        this.mVfd.height = height;
        this.mVfd.rotation = VideoRotation.fromId(rotation);
        this.mVfd.timestampUs = timestampUs;
        this.mVfd.numberOfPlanes = numberOfPlanes;
        this.mVfd.planeData = planeArray;
        this.mVfd.planeStride = strideArray;
        this.mVfd.seiData = seiData;
        this.mVfd.textureId = textureId;
        this.mVfd.textureMatrix = textureMatrix;
        this.mVfd.eglContext = eglCtxHandle;
        this.mVfd.fovTileInfo = fovInfo;
        this.mCameraId = CameraId.fromId(cameraId);
        this.mCaptureTimeStamp = captureTimestampUs;
        nativeAddRef(this.mNativePtr);
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public VideoBufferType bufferType() {
        return this.mVfd.bufferType;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public VideoPixelFormat pixelFormat() {
        return this.mVfd.pixelFormat;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public VideoContentType contentType() {
        return this.mVfd.contentType;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public long timestampUs() {
        return this.mVfd.timestampUs;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public long captureTimestampMs() {
        return this.mCaptureTimeStamp;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public int width() {
        return this.mVfd.width;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public int height() {
        return this.mVfd.height;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public VideoRotation rotation() {
        return this.mVfd.rotation;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public int numberOfPlanes() {
        return this.mVfd.numberOfPlanes;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public ByteBuffer planeData(int planeIndex) {
        if (planeIndex >= this.mVfd.numberOfPlanes) {
            return null;
        }
        return this.mVfd.planeData[planeIndex];
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public int planeStride(int planeIndex) {
        if (planeIndex >= this.mVfd.numberOfPlanes) {
            return 0;
        }
        return this.mVfd.planeStride[planeIndex];
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public ByteBuffer seiData() {
        return this.mVfd.seiData;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public int textureId() {
        return this.mVfd.textureId;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public float[] textureMatrix() {
        return this.mVfd.textureMatrix;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public EGLContext eglContext() {
        return this.mVfd.eglContext;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public void addRef() {
        if (this.mRefCount.getAndIncrement() < 1) {
            throw new ArithmeticException("addRef on an object that has already been destroyed.");
        }
        nativeAddRef(this.mNativePtr);
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public long releaseRef() {
        if (this.mRefCount.getAndDecrement() >= 1) {
            nativeReleaseRef(this.mNativePtr);
        }
        return this.mRefCount.get();
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public FovVideoFrameInfo fovTileInfo() {
        return this.mVfd.fovTileInfo;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public CameraId cameraId() {
        return this.mCameraId;
    }

    public static long ConvertVideoFrameToIVideoFrame(IVideoFrame vf) {
        ByteBuffer[] byteBufferArr = new ByteBuffer[3];
        int[] iArr = new int[3];
        for (int i = 0; i < vf.numberOfPlanes(); i++) {
            byteBufferArr[i] = ensureDirectBuffer(vf.planeData(i));
            iArr[i] = vf.planeStride(i);
        }
        return nativeCreateIVideoFrame(vf, vf.bufferType().value(), vf.pixelFormat().value(), vf.contentType().value(), vf.width(), vf.height(), vf.rotation().value(), vf.numberOfPlanes(), byteBufferArr, iArr, ensureDirectBuffer(vf.seiData()), vf.textureId(), vf.textureMatrix(), vf.eglContext(), vf.cameraId().value());
    }

    static ByteBuffer ensureDirectBuffer(ByteBuffer b) {
        if (b == null || b.isDirect()) {
            return b;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(b.remaining());
        allocateDirect.position(0);
        allocateDirect.put(b);
        allocateDirect.rewind();
        return allocateDirect;
    }

    public static void addRefOfVideoFrame(IVideoFrame vf) {
        vf.addRef();
    }

    public static long releaseRefOfVideoFrame(IVideoFrame vf) {
        return vf.releaseRef();
    }

    public static long ConvertJVideoFrameDataToVideoFrameData(VideoFrameData vfd) {
        ByteBuffer[] byteBufferArr = new ByteBuffer[3];
        for (int i = 0; i < vfd.numberOfPlanes; i++) {
            byteBufferArr[i] = ensureDirectBuffer(vfd.planeData[i]);
        }
        return nativeCreateVideoFrameData(vfd.bufferType.value(), vfd.pixelFormat.value(), vfd.contentType.value(), vfd.width, vfd.height, vfd.rotation.value(), vfd.timestampUs, vfd.numberOfPlanes, byteBufferArr, vfd.planeStride, ensureDirectBuffer(vfd.seiData), ensureDirectBuffer(vfd.roiData), vfd.textureId, vfd.textureMatrix, vfd.eglContext);
    }
}
