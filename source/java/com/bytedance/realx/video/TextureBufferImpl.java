package com.bytedance.realx.video;

import android.graphics.Matrix;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Handler;
import com.bytedance.realx.base.RefCountDelegate;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.VideoFrame;
import java.util.concurrent.Callable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TextureBufferImpl implements VideoFrame.TextureBuffer {
    private final int height;

    /* renamed from: id */
    private final int f99id;
    private final RefCountDelegate refCountDelegate;
    private FilterType scaleFilter;
    private final Handler toI420Handler;
    private final Matrix transformMatrix;
    private final VideoFrame.TextureBuffer.Type type;
    private final int unscaledHeight;
    private final int unscaledWidth;
    private final int width;
    private final YuvConverter yuvConverter;

    public TextureBufferImpl(int width, int height, VideoFrame.TextureBuffer.Type type, int id, Matrix transformMatrix, Handler toI420Handler, YuvConverter yuvConverter, Runnable releaseCallback) {
        this.unscaledWidth = width;
        this.unscaledHeight = height;
        this.width = width;
        this.height = height;
        this.type = type;
        this.f99id = id;
        this.transformMatrix = transformMatrix;
        this.toI420Handler = toI420Handler;
        this.yuvConverter = yuvConverter;
        this.refCountDelegate = new RefCountDelegate(releaseCallback);
    }

    private TextureBufferImpl(int unscaledWidth, int unscaledHeight, int width, int height, VideoFrame.TextureBuffer.Type type, int id, FilterType scaleFilter, Matrix transformMatrix, Handler toI420Handler, YuvConverter yuvConverter, Runnable releaseCallback) {
        this.unscaledWidth = unscaledWidth;
        this.unscaledHeight = unscaledHeight;
        this.width = width;
        this.height = height;
        this.type = type;
        this.f99id = id;
        this.scaleFilter = scaleFilter;
        this.transformMatrix = transformMatrix;
        this.toI420Handler = toI420Handler;
        this.yuvConverter = yuvConverter;
        this.refCountDelegate = new RefCountDelegate(releaseCallback);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public EGLContext getEglContext() {
        Handler handler = this.toI420Handler;
        if (handler == null) {
            return null;
        }
        return (EGLContext) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable() { // from class: com.bytedance.realx.video.TextureBufferImpl$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                EGLContext eglGetCurrentContext;
                eglGetCurrentContext = EGL14.eglGetCurrentContext();
                return eglGetCurrentContext;
            }
        });
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public long getNativeEglContext() {
        EGLContext eglContext = getEglContext();
        if (eglContext == null) {
            return 0L;
        }
        return eglContext.getNativeHandle();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        return this.type;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTextureId() {
        return this.f99id;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTypeGlTarget() {
        return this.type.getGlTarget();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public FilterType getScaleFilter() {
        return this.scaleFilter;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public float[] nativeGetTransFormMatrix() {
        return RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.transformMatrix);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        FilterType filterType = this.scaleFilter;
        if (filterType == null || filterType == FilterType.Origin) {
            return (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable() { // from class: com.bytedance.realx.video.TextureBufferImpl$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return TextureBufferImpl.this.m807lambda$toI420$1$combytedancerealxvideoTextureBufferImpl();
                }
            });
        }
        return (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable() { // from class: com.bytedance.realx.video.TextureBufferImpl$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TextureBufferImpl.this.m808lambda$toI420$2$combytedancerealxvideoTextureBufferImpl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$toI420$1$com-bytedance-realx-video-TextureBufferImpl, reason: not valid java name */
    public /* synthetic */ VideoFrame.I420Buffer m807lambda$toI420$1$combytedancerealxvideoTextureBufferImpl() throws Exception {
        return this.yuvConverter.convert(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$toI420$2$com-bytedance-realx-video-TextureBufferImpl, reason: not valid java name */
    public /* synthetic */ VideoFrame.I420Buffer m808lambda$toI420$2$combytedancerealxvideoTextureBufferImpl() throws Exception {
        return this.yuvConverter.convert(this, this.scaleFilter, this.unscaledWidth, this.unscaledHeight);
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
    public VideoFrame.Buffer copyData() {
        return (VideoFrame.Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable() { // from class: com.bytedance.realx.video.TextureBufferImpl$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TextureBufferImpl.this.m806lambda$copyData$4$combytedancerealxvideoTextureBufferImpl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$copyData$4$com-bytedance-realx-video-TextureBufferImpl, reason: not valid java name */
    public /* synthetic */ TextureBufferImpl m806lambda$copyData$4$combytedancerealxvideoTextureBufferImpl() throws Exception {
        final int dequeueTexture = this.yuvConverter.dequeueTexture(this.width, this.height);
        if (dequeueTexture == 0) {
            return null;
        }
        this.yuvConverter.drawTexture(this.type == VideoFrame.TextureBuffer.Type.OES ? 11 : 10, this.f99id, dequeueTexture, this.width, this.height);
        return new TextureBufferImpl(this.width, this.height, VideoFrame.TextureBuffer.Type.RGB, dequeueTexture, this.transformMatrix, this.toI420Handler, this.yuvConverter, new Runnable() { // from class: com.bytedance.realx.video.TextureBufferImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                TextureBufferImpl.this.m805lambda$copyData$3$combytedancerealxvideoTextureBufferImpl(dequeueTexture);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$copyData$3$com-bytedance-realx-video-TextureBufferImpl, reason: not valid java name */
    public /* synthetic */ void m805lambda$copyData$3$combytedancerealxvideoTextureBufferImpl(int i) {
        this.yuvConverter.queueTexture(i);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(cropX / this.width, (r0 - (cropY + cropHeight)) / this.height);
        matrix.preScale(cropWidth / this.width, cropHeight / this.height);
        this.scaleFilter = FilterType.Origin;
        return applyTransformMatrix(matrix, Math.round((this.unscaledWidth * cropWidth) / this.width), Math.round((this.unscaledHeight * cropHeight) / this.height), scaleWidth, scaleHeight);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.Buffer cropAndScaleWithFilter(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight, int scaleFilterVal) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(cropX / this.width, (r0 - (cropY + cropHeight)) / this.height);
        matrix.preScale(cropWidth / this.width, cropHeight / this.height);
        this.scaleFilter = FilterType.fromValue(scaleFilterVal);
        return applyTransformMatrix(matrix, Math.round((this.unscaledWidth * cropWidth) / this.width), Math.round((this.unscaledHeight * cropHeight) / this.height), scaleWidth, scaleHeight);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int dstWidth, int dstHeight, int offsetX, int offsetY) {
        Matrix matrix = new Matrix();
        matrix.preScale(Math.min(dstWidth, (getWidth() * dstHeight) / getHeight()) / getWidth(), Math.min(dstHeight, (getHeight() * dstWidth) / getWidth()) / getHeight());
        matrix.preTranslate(offsetX / dstWidth, (dstHeight - (offsetY + r2)) / dstHeight);
        return applyTransformMatrix(matrix, dstWidth, dstHeight);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledWidth() {
        return this.unscaledWidth;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledHeight() {
        return this.unscaledHeight;
    }

    public TextureBufferImpl applyTransformMatrix(Matrix transformMatrix, int newWidth, int newHeight) {
        return applyTransformMatrix(transformMatrix, newWidth, newHeight, newWidth, newHeight);
    }

    private TextureBufferImpl applyTransformMatrix(Matrix transformMatrix, int unscaledWidth, int unscaledHeight, int scaledWidth, int scaledHeight) {
        Matrix matrix = new Matrix(this.transformMatrix);
        matrix.preConcat(transformMatrix);
        retain();
        return new TextureBufferImpl(unscaledWidth, unscaledHeight, scaledWidth, scaledHeight, this.type, this.f99id, this.scaleFilter, matrix, this.toI420Handler, this.yuvConverter, new Runnable() { // from class: com.bytedance.realx.video.TextureBufferImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                TextureBufferImpl.this.release();
            }
        });
    }
}
