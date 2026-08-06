package com.ss.bytertc.base.media;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.realx.base.RXLogging;

/* loaded from: classes7.dex */
public class RTCSurfaceTextureListener implements TextureView.SurfaceTextureListener {
    private final String key;
    private long nativeSurfaceHelperHandle;
    private boolean needFristFrameRenderedCallback;
    private TextureView textureView;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RTCSurfaceTextureListener(TextureView targetView, final long nativeSurfaceHelperHandle, final String key, final boolean needCallback) {
        this.nativeSurfaceHelperHandle = 0L;
        this.needFristFrameRenderedCallback = false;
        this.textureView = targetView;
        this.key = key;
        final SurfaceTexture surfaceTexture = targetView != null ? targetView.getSurfaceTexture() : null;
        this.nativeSurfaceHelperHandle = nativeSurfaceHelperHandle;
        this.needFristFrameRenderedCallback = needCallback;
        if (surfaceTexture == null || nativeSurfaceHelperHandle == 0) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ss.bytertc.base.media.RTCSurfaceTextureListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RTCSurfaceTextureListener.this.m9426lambda$new$0$comssbytertcbasemediaRTCSurfaceTextureListener(surfaceTexture, nativeSurfaceHelperHandle, key, needCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-ss-bytertc-base-media-RTCSurfaceTextureListener, reason: not valid java name */
    public /* synthetic */ void m9426lambda$new$0$comssbytertcbasemediaRTCSurfaceTextureListener(SurfaceTexture surfaceTexture, long j, String str, boolean z) {
        SurfaceTexture surfaceTexture2 = this.textureView.getSurfaceTexture();
        if (surfaceTexture2 == null || surfaceTexture2 != surfaceTexture) {
            return;
        }
        RTCSurfaceHelper.nativeSetRenderTarget(j, new Surface(surfaceTexture2), str, z);
    }

    public void resetCallback() {
        this.nativeSurfaceHelperHandle = 0L;
        TextureView textureView = this.textureView;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        if (this.nativeSurfaceHelperHandle != 0) {
            RXLogging.i("RTCSurfaceTextureListener", "onSurfaceTextureAvailable key:" + this.key);
            RTCSurfaceHelper.nativeSetRenderTarget(this.nativeSurfaceHelperHandle, new Surface(surfaceTexture), this.key, this.needFristFrameRenderedCallback);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.needFristFrameRenderedCallback = false;
        if (this.nativeSurfaceHelperHandle == 0) {
            return true;
        }
        RXLogging.i("RTCSurfaceTextureListener", "onSurfaceTextureDestroyed key:" + this.key);
        RTCSurfaceHelper.nativeSetRenderTarget(this.nativeSurfaceHelperHandle, null, this.key, false);
        return true;
    }
}
