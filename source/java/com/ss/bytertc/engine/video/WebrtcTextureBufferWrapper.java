package com.ss.bytertc.engine.video;

import android.graphics.Matrix;
import android.opengl.EGLContext;
import com.bytedance.realx.video.FilterType;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class WebrtcTextureBufferWrapper implements ITextureBuffer, VideoFrame.TextureBuffer {
    TextureBufferImpl webrtcTextureBuffer;

    public WebrtcTextureBufferWrapper(TextureBufferImpl webrtcTextureBuffer) {
        this.webrtcTextureBuffer = webrtcTextureBuffer;
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer
    public int getTypeGlTarget() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return 0;
        }
        return textureBufferImpl.getType().getGlTarget();
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer
    public int getTextureId() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return 0;
        }
        return textureBufferImpl.getTextureId();
    }

    public Matrix getTransformMatrix() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return new Matrix();
        }
        return textureBufferImpl.getTransformMatrix();
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer
    public float[] nativeGetTransFormMatrix() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        return textureBufferImpl == null ? new float[]{0.0f} : RendererCommon.convertMatrixFromAndroidGraphicsMatrix(textureBufferImpl.getTransformMatrix());
    }

    public EGLContext getEglContext() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return null;
        }
        return textureBufferImpl.getEglContext();
    }

    public long getNativeEglContext() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return 0L;
        }
        return textureBufferImpl.getNativeEglContext();
    }

    public VideoFrame.TextureBuffer.Type getType() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return VideoFrame.TextureBuffer.Type.OES;
        }
        return textureBufferImpl.getType();
    }

    public int getWidth() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return 0;
        }
        return textureBufferImpl.getWidth();
    }

    public int getHeight() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return 0;
        }
        return textureBufferImpl.getHeight();
    }

    public FilterType getScaleFilter() {
        return FilterType.Origin;
    }

    public int getUnscaledWidth() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return 0;
        }
        return textureBufferImpl.getUnscaledWidth();
    }

    public int getUnscaledHeight() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return 0;
        }
        return textureBufferImpl.getUnscaledHeight();
    }

    public VideoFrame.I420Buffer toI420() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return null;
        }
        return textureBufferImpl.toI420();
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer
    public void retain() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return;
        }
        textureBufferImpl.retain();
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer
    public void release() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return;
        }
        textureBufferImpl.release();
    }

    public VideoFrame.Buffer cropAndScaleWithFilter(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight, int scaleFilter) {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return null;
        }
        return textureBufferImpl.cropAndScale(cropX, cropY, cropWidth, cropHeight, scaleWidth, scaleHeight);
    }

    public VideoFrame.Buffer cropAndScale(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight) {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return null;
        }
        return textureBufferImpl.cropAndScale(cropX, cropY, cropWidth, cropHeight, scaleWidth, scaleHeight);
    }

    public VideoFrame.Buffer scaleAndFill(int dstWidth, int dstHeight, int offsetX, int offsetY) {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return null;
        }
        return textureBufferImpl.scaleAndFill(dstWidth, dstHeight, offsetX, offsetY);
    }

    public VideoFrame.Buffer copyData() {
        TextureBufferImpl textureBufferImpl = this.webrtcTextureBuffer;
        if (textureBufferImpl == null) {
            return null;
        }
        return textureBufferImpl.copyData();
    }
}
