package com.bytedance.realx.video.memory;

import android.graphics.Matrix;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.bytedance.realx.video.MediaCodecTextureBufferHelper;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.RXVideoMemoryType;
import com.bytedance.realx.video.RXVideoRotation;
import com.bytedance.realx.video.RXVideoScaleFilter;
import com.bytedance.realx.video.RendererCommon;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NativeRXOpenGLMemory extends RXVideoMemory implements RXVideoOpenGLMemoryInterface {
    private static native long nativeCreateOpenGLMemory(int width, int height, int originalWidth, int originalHeight, int texture, RXPixelFormat format, float[] matrix, EGLContext context, RXVideoScaleFilter filterType, RXVideoRotation rotation, Runnable releaseCallback);

    private static native long nativeGetGLSync(long nativeHandle);

    private static native int nativeGetHeight(long nativeHandle);

    private static native EGLContext nativeGetJavaEGLContext(long nativeHandle);

    private static native long nativeGetNativeEGLContext(long nativeHandle);

    private static native RXVideoRotation nativeGetRotation(long nativeHandle);

    private static native RXVideoScaleFilter nativeGetScaleFilter(long nativeHandle);

    private static native int nativeGetTextureId(long nativeHandle);

    private static native float[] nativeGetTextureMatrix(long nativeHandle);

    private static native RXPixelFormat nativeGetTextureTarget(long nativeHandle);

    private static native int nativeGetUnscaledHeight(long nativeHandle);

    private static native int nativeGetUnscaledWidth(long nativeHandle);

    private static native RXVideoMemoryType nativeGetVideoMemoryType(long nativeHandle);

    private static native int nativeGetWidth(long nativeHandle);

    private static native void nativeReleaseTextureVideoMemory(long nativeHandle);

    private static native void nativeSetRenderHelper(long nativeHandle, MediaCodecTextureBufferHelper textureHelper);

    public static NativeRXOpenGLMemory createRXOpenGLMemory(int width, int height, int originalWidth, int originalHeight, int texture, RXPixelFormat format, float[] matrix, EGLContext context, RXVideoScaleFilter filterType, RXVideoRotation rotation, Runnable runnable) {
        return new NativeRXOpenGLMemory(nativeCreateOpenGLMemory(width, height, originalWidth, originalHeight, texture, format, matrix, context, filterType, rotation, runnable));
    }

    NativeRXOpenGLMemory(long nativeHandle) {
        super(nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public RXVideoRotation getRotation() {
        if (isNullPointer()) {
            return null;
        }
        return nativeGetRotation(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public RXVideoMemoryType getMemoryType() {
        if (isNullPointer()) {
            return null;
        }
        return nativeGetVideoMemoryType(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public RXPixelFormat getPixelFormat() {
        return getTextureTarget();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public int getTextureId() {
        if (isNullPointer()) {
            return 0;
        }
        return nativeGetTextureId(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public long getGLSync() {
        if (isNullPointer()) {
            return 0L;
        }
        return nativeGetGLSync(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public float[] getTextureMatrix() {
        if (!isNullPointer()) {
            return nativeGetTextureMatrix(this.nativeHandle);
        }
        float[] fArr = new float[16];
        fArr[0] = 1.0f;
        fArr[5] = 1.0f;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
        return fArr;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public Matrix getAndroidTextureMatrix() {
        if (isNullPointer()) {
            return new Matrix();
        }
        return RendererCommon.convertMatrixToAndroidGraphicsMatrix(nativeGetTextureMatrix(this.nativeHandle));
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public RXPixelFormat getTextureTarget() {
        if (isNullPointer()) {
            return RXPixelFormat.kUnknown;
        }
        return nativeGetTextureTarget(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public long getNativeEGLContext() {
        if (isNullPointer()) {
            return 0L;
        }
        return nativeGetNativeEGLContext(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public EGLContext getEGLContext() {
        if (isNullPointer()) {
            return EGL14.EGL_NO_CONTEXT;
        }
        return nativeGetJavaEGLContext(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public int getWidth() {
        return nativeGetWidth(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public int getHeight() {
        return nativeGetHeight(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public int getUnScaledWidth() {
        return nativeGetUnscaledWidth(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public int getUnScaledHeight() {
        return nativeGetUnscaledHeight(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public RXVideoScaleFilter getScaleFilter() {
        return nativeGetScaleFilter(this.nativeHandle);
    }

    public void setRenderHelper(MediaCodecTextureBufferHelper helper) {
        nativeSetRenderHelper(this.nativeHandle, helper);
    }

    private static void release(Runnable releaseCallback) {
        if (releaseCallback != null) {
            releaseCallback.run();
        }
    }
}
