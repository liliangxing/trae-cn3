package com.ss.bytertc.base.media;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class Texture2DToWebRTCVideoFrame {
    Handler mHandler;
    Matrix mMat;
    boolean needPendingRelease;
    YuvConverter yuvConverter = new YuvConverter();
    boolean isReleased = false;
    boolean isFrameInUse = false;

    public Texture2DToWebRTCVideoFrame() {
        this.mHandler = null;
        this.needPendingRelease = false;
        HandlerThread handlerThread = new HandlerThread("Texture2DToVideoFrame");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.needPendingRelease = false;
        Matrix matrix = new Matrix();
        this.mMat = matrix;
        matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseFrame() {
        this.isFrameInUse = false;
        if (!this.needPendingRelease || this.isReleased) {
            return;
        }
        this.isReleased = true;
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: com.ss.bytertc.base.media.Texture2DToWebRTCVideoFrame$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Texture2DToWebRTCVideoFrame.this.m184x16ed73a2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$releaseFrame$0$com-ss-bytertc-base-media-Texture2DToWebRTCVideoFrame */
    public /* synthetic */ void m184x16ed73a2() {
        this.yuvConverter.release();
        this.mHandler.getLooper().quit();
    }

    public boolean isFameInUse() {
        return this.isFrameInUse;
    }

    public VideoFrame convertTexture2DToWebRTCVideoFrame(int textureId, int width, int height) {
        if (this.needPendingRelease || this.isReleased) {
            return null;
        }
        this.isFrameInUse = true;
        return new VideoFrame(new TextureBufferImpl(width, height, VideoFrame.TextureBuffer.Type.RGB, textureId, this.mMat, this.mHandler, this.yuvConverter, new Runnable() { // from class: com.ss.bytertc.base.media.Texture2DToWebRTCVideoFrame$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Texture2DToWebRTCVideoFrame.this.releaseFrame();
            }
        }), 0, 0L);
    }

    public void release() {
        if (this.isFrameInUse) {
            this.needPendingRelease = true;
        } else {
            this.isReleased = true;
            ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new Runnable() { // from class: com.ss.bytertc.base.media.Texture2DToWebRTCVideoFrame$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Texture2DToWebRTCVideoFrame.this.m183x74912caa();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$1$com-ss-bytertc-base-media-Texture2DToWebRTCVideoFrame */
    public /* synthetic */ void m183x74912caa() {
        this.yuvConverter.release();
        this.mHandler.getLooper().quit();
    }
}
