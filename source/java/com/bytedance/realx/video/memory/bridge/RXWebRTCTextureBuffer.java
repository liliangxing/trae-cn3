package com.bytedance.realx.video.memory.bridge;

import android.graphics.Matrix;
import android.opengl.EGLContext;
import com.bytedance.realx.base.RefCountDelegate;
import com.bytedance.realx.video.FilterType;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.RXVideoScaleFilter;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;

/* loaded from: classes4.dex */
public class RXWebRTCTextureBuffer implements VideoFrame.TextureBuffer {
    private boolean isAgfxTexture;
    private final long nativeRXVideoFrame;
    private final RefCountDelegate refCountDelegate;

    private static native long nativeCreateTextureRXVideoFrame(long nativeHandle, float[] matrix, int unscaledWidth, int unscaledHeight, int width, int height, RXVideoScaleFilter scaleFilter);

    private static native EGLContext nativeGetAndroidEGLContext(long nativeHandle);

    private static native EGLContext nativeGetEGLContext(long nativeHandle);

    private static native float[] nativeGetFloatTextureMatrix(long nativeHandle);

    private static native int nativeGetHeight(long nativeHandle);

    private static native RXPixelFormat nativeGetPixelFormat(long nativeHandle);

    private static native RXVideoScaleFilter nativeGetRXVideoScaleFilter(long nativeHandle);

    private static native int nativeGetTextureId(long nativeHandle);

    private static native int nativeGetUnscaledHeight(long nativeHandle);

    private static native int nativeGetUnscaledWidth(long nativeHandle);

    private static native int nativeGetWidth(long nativeHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeReleaseRXVideoFrame(long nativeHandle);

    private static native VideoFrame.I420Buffer nativeToI420(long nativeHandle);

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return null;
    }

    RXWebRTCTextureBuffer(final long nativeRXVideoFrame, boolean isAGFXTexture) {
        this.nativeRXVideoFrame = nativeRXVideoFrame;
        this.isAgfxTexture = isAGFXTexture;
        this.refCountDelegate = new RefCountDelegate(new Runnable() { // from class: com.bytedance.realx.video.memory.bridge.RXWebRTCTextureBuffer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RXWebRTCTextureBuffer.nativeReleaseRXVideoFrame(nativeRXVideoFrame);
            }
        });
    }

    EGLContext getEGLContext() {
        return nativeGetAndroidEGLContext(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return nativeGetWidth(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return nativeGetHeight(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        return nativeToI420(this.nativeRXVideoFrame);
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
        if (this.isAgfxTexture) {
            return null;
        }
        int width = getWidth();
        int height = getHeight();
        int unscaledWidth = getUnscaledWidth();
        int unscaledHeight = getUnscaledHeight();
        Matrix matrix = new Matrix();
        float f = width;
        float f2 = height - (cropY + cropHeight);
        float f3 = height;
        matrix.preTranslate(cropX / f, f2 / f3);
        matrix.preScale(cropWidth / f, cropHeight / f3);
        return applyTransformMatrix(matrix, Math.round((unscaledWidth * cropWidth) / f), Math.round((unscaledHeight * cropHeight) / f3), scaleWidth, scaleHeight, FilterType.Origin);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.Buffer cropAndScaleWithFilter(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight, int scaleFilter) {
        if (this.isAgfxTexture) {
            return null;
        }
        int width = getWidth();
        int height = getHeight();
        int unscaledWidth = getUnscaledWidth();
        int unscaledHeight = getUnscaledHeight();
        Matrix matrix = new Matrix();
        float f = width;
        float f2 = height - (cropY + cropHeight);
        float f3 = height;
        matrix.preTranslate(cropX / f, f2 / f3);
        matrix.preScale(cropWidth / f, cropHeight / f3);
        return applyTransformMatrix(matrix, Math.round((unscaledWidth * cropWidth) / f), Math.round((unscaledHeight * cropHeight) / f3), scaleWidth, scaleHeight, FilterType.fromValue(scaleFilter));
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int dstWidth, int dstHeight, int offsetX, int offsetY) {
        if (this.isAgfxTexture) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(Math.min(dstWidth, (getWidth() * dstHeight) / getHeight()) / getWidth(), Math.min(dstHeight, (getHeight() * dstWidth) / getWidth()) / getHeight());
        matrix.preTranslate(offsetX / dstWidth, (dstHeight - (offsetY + r2)) / dstHeight);
        return applyTransformMatrix(matrix, dstWidth, dstHeight);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public EGLContext getEglContext() {
        return nativeGetEGLContext(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public long getNativeEglContext() {
        EGLContext eGLContext = getEGLContext();
        if (eGLContext == null) {
            return 0L;
        }
        return eGLContext.getNativeHandle();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        RXPixelFormat nativeGetPixelFormat = nativeGetPixelFormat(this.nativeRXVideoFrame);
        if (nativeGetPixelFormat == RXPixelFormat.kTexture2D) {
            return VideoFrame.TextureBuffer.Type.RGB;
        }
        if (nativeGetPixelFormat == RXPixelFormat.kTextureOES) {
            return VideoFrame.TextureBuffer.Type.OES;
        }
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTextureId() {
        return nativeGetTextureId(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        return RendererCommon.convertMatrixToAndroidGraphicsMatrix(nativeGetFloatTextureMatrix(this.nativeRXVideoFrame));
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public float[] nativeGetTransFormMatrix() {
        return nativeGetFloatTextureMatrix(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTypeGlTarget() {
        return getType().getGlTarget();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public FilterType getScaleFilter() {
        return FilterType.fromValue(nativeGetRXVideoScaleFilter(this.nativeRXVideoFrame).value());
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledWidth() {
        return nativeGetUnscaledWidth(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledHeight() {
        return nativeGetUnscaledHeight(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer, com.bytedance.realx.video.VideoFrame.Buffer
    public int getBufferType() {
        return super.getBufferType();
    }

    public VideoFrame.TextureBuffer applyTransformMatrix(Matrix transformMatrix, int newWidth, int newHeight) {
        return applyTransformMatrix(transformMatrix, newWidth, newHeight, newWidth, newHeight, FilterType.Origin);
    }

    private VideoFrame.TextureBuffer applyTransformMatrix(Matrix cropAndScraleMatrix, int unscaledWidth, int unscaledHeight, int scaledWidth, int scaledHeight, FilterType scaleFilter) {
        if (this.isAgfxTexture) {
            return null;
        }
        Matrix matrix = new Matrix(getTransformMatrix());
        matrix.preConcat(cropAndScraleMatrix);
        retain();
        RXVideoScaleFilter fromId = RXVideoScaleFilter.fromId(scaleFilter.toInt());
        return new RXWebRTCTextureBuffer(nativeCreateTextureRXVideoFrame(this.nativeRXVideoFrame, RendererCommon.convertMatrixFromAndroidGraphicsMatrix(matrix), unscaledWidth, unscaledHeight, scaledWidth, scaledHeight, fromId), false);
    }
}
