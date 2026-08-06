package com.bytedance.realx.video.memory.bridge;

import android.opengl.EGLContext;
import com.bytedance.realx.video.FilterType;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.RXVideoMemoryType;
import com.bytedance.realx.video.RXVideoRotation;
import com.bytedance.realx.video.RXVideoScaleFilter;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.memory.RXVideoTextureMemory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WebrtcTextureVideoMemory extends RXVideoTextureMemory {
    EGLContext eglContext;
    RXVideoRotation rotation;
    private VideoFrame.TextureBuffer textureBuffer;

    public WebrtcTextureVideoMemory(VideoFrame.TextureBuffer textureBuffer, EGLContext eglContext, RXVideoRotation rotation) {
        this.textureBuffer = textureBuffer;
        this.eglContext = eglContext;
        this.rotation = rotation;
        if (textureBuffer != null) {
            textureBuffer.retain();
        }
        setReleaseCallback(new Runnable() { // from class: com.bytedance.realx.video.memory.bridge.WebrtcTextureVideoMemory$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WebrtcTextureVideoMemory.this.m300xdae21ece();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-bytedance-realx-video-memory-bridge-WebrtcTextureVideoMemory */
    public /* synthetic */ void m300xdae21ece() {
        VideoFrame.TextureBuffer textureBuffer = this.textureBuffer;
        if (textureBuffer != null) {
            textureBuffer.release();
        }
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public int getWidth() {
        VideoFrame.TextureBuffer textureBuffer = this.textureBuffer;
        if (textureBuffer == null) {
            return 0;
        }
        return textureBuffer.getWidth();
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public int getHeight() {
        VideoFrame.TextureBuffer textureBuffer = this.textureBuffer;
        if (textureBuffer == null) {
            return 0;
        }
        return textureBuffer.getHeight();
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public RXVideoRotation getRotation() {
        if (this.textureBuffer == null) {
            return RXVideoRotation.VIDEO_ROTATION_0;
        }
        return this.rotation;
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public RXVideoMemoryType getMemoryType() {
        return RXVideoMemoryType.kOPENGL_TEXTURE;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public int getTextureId() {
        VideoFrame.TextureBuffer textureBuffer = this.textureBuffer;
        if (textureBuffer == null) {
            return 0;
        }
        return textureBuffer.getTextureId();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public float[] getTextureMatrix() {
        VideoFrame.TextureBuffer textureBuffer = this.textureBuffer;
        if (textureBuffer != null) {
            return textureBuffer.nativeGetTransFormMatrix();
        }
        float[] fArr = new float[16];
        fArr[0] = 1.0f;
        fArr[5] = 1.0f;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
        return fArr;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public RXPixelFormat getTextureTarget() {
        VideoFrame.TextureBuffer textureBuffer = this.textureBuffer;
        if (textureBuffer == null) {
            return null;
        }
        return RXPixelFormat.fromId(textureBuffer.getTypeGlTarget());
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public long getNativeEGLContext() {
        if (this.eglContext == null) {
            return 0L;
        }
        return this.eglContext.getNativeHandle();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public EGLContext getEGLContext() {
        return this.eglContext;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public RXVideoScaleFilter getScaleFilter() {
        FilterType scaleFilter = this.textureBuffer.getScaleFilter();
        if (scaleFilter == null) {
            return RXVideoScaleFilter.kOpenGLOrigin;
        }
        return RXVideoScaleFilter.fromId(scaleFilter.toInt());
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public int getUnScaledWidth() {
        VideoFrame.TextureBuffer textureBuffer = this.textureBuffer;
        if (textureBuffer == null) {
            return 0;
        }
        return textureBuffer.getUnscaledWidth();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public int getUnScaledHeight() {
        VideoFrame.TextureBuffer textureBuffer = this.textureBuffer;
        if (textureBuffer == null) {
            return 0;
        }
        return textureBuffer.getUnscaledHeight();
    }
}
