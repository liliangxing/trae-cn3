package com.ss.bytertc.base.media;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.realx.base.RXLogging;

/* loaded from: classes7.dex */
public class RTCSurfaceViewListener implements SurfaceHolder.Callback {
    private final String key;
    private long nativeSurfaceHelperHandle;
    private boolean needFristFrameRenderedCallback;
    private SurfaceView surfaceView;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RTCSurfaceViewListener(SurfaceView renderView, final long nativeSurfaceHelperHandle, final String key, final boolean needCallback) {
        SurfaceHolder holder;
        Surface surface;
        this.nativeSurfaceHelperHandle = nativeSurfaceHelperHandle;
        this.surfaceView = renderView;
        this.key = key;
        this.needFristFrameRenderedCallback = needCallback;
        final Surface surface2 = (renderView == null || renderView.getHolder() == null || (holder = this.surfaceView.getHolder()) == null || holder.getSurface() == null || (surface = holder.getSurface()) == null || !surface.isValid()) ? null : holder.getSurface();
        if (surface2 == null || this.nativeSurfaceHelperHandle == 0) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ss.bytertc.base.media.RTCSurfaceViewListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RTCSurfaceViewListener.this.m9427lambda$new$0$comssbytertcbasemediaRTCSurfaceViewListener(surface2, nativeSurfaceHelperHandle, key, needCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-ss-bytertc-base-media-RTCSurfaceViewListener, reason: not valid java name */
    public /* synthetic */ void m9427lambda$new$0$comssbytertcbasemediaRTCSurfaceViewListener(Surface surface, long j, String str, boolean z) {
        Surface surface2 = this.surfaceView.getHolder().getSurface();
        if (surface2 != null && surface2.isValid() && surface2 == surface) {
            RTCSurfaceHelper.nativeSetRenderTarget(j, surface2, str, z);
        }
    }

    public void resetCallback() {
        this.nativeSurfaceHelperHandle = 0L;
        SurfaceView surfaceView = this.surfaceView;
        if (surfaceView != null) {
            surfaceView.getHolder().removeCallback(this);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.nativeSurfaceHelperHandle == 0 || surfaceHolder == null || surfaceHolder.getSurface() == null || !surfaceHolder.getSurface().isValid()) {
            return;
        }
        RXLogging.i("RTCSurfaceViewListener", "surfaceCreated key:" + this.key);
        RTCSurfaceHelper.nativeSetRenderTarget(this.nativeSurfaceHelperHandle, surfaceHolder.getSurface(), this.key, this.needFristFrameRenderedCallback);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.needFristFrameRenderedCallback = false;
        if (this.nativeSurfaceHelperHandle != 0) {
            RXLogging.i("RTCSurfaceViewListener", "surfaceDestroyed key:" + this.key);
            RTCSurfaceHelper.nativeSetRenderTarget(this.nativeSurfaceHelperHandle, null, this.key, false);
        }
    }
}
