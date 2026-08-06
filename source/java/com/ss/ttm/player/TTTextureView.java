package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.ss.ttm.player.ITTRenderView;

/* loaded from: classes7.dex */
class TTTextureView extends TextureView implements ITTRenderView, TextureView.SurfaceTextureListener {
    private boolean mEnableSurfaceTextureReuse;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private ITTRenderView.RenderCallback renderCallback;

    @Override // com.ss.ttm.player.ITTRenderView
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setFixedSizeIfNeeded(int width, int height) {
    }

    public TTTextureView(Context context) {
        super(context);
        this.mSurface = null;
        this.mSurfaceTexture = null;
        this.mEnableSurfaceTextureReuse = false;
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public Surface getSurface() {
        return this.mSurface;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setRenderCallback(ITTRenderView.RenderCallback callback) {
        this.renderCallback = callback;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void reCreateSurface() {
        ITTRenderView.RenderCallback renderCallback = this.renderCallback;
        if (renderCallback == null || this.mSurfaceTexture == null) {
            return;
        }
        renderCallback.onSurfaceDestroyed();
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        Surface surface2 = new Surface(this.mSurfaceTexture);
        this.mSurface = surface2;
        this.renderCallback.onSurfaceCreated(surface2);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void snapshotBitmap(boolean highQuality, ITTRenderView.SnapshotCallback callback) {
        if (callback == null) {
            return;
        }
        Bitmap bitmap = getBitmap();
        callback.onResult(bitmap != null ? 0 : -1, bitmap);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void reuse() {
        this.mEnableSurfaceTextureReuse = true;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        reusedSurfaceTexture();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        if (!this.mEnableSurfaceTextureReuse || this.mSurfaceTexture == null) {
            this.mSurfaceTexture = surface;
            this.mSurface = new Surface(surface);
        }
        ITTRenderView.RenderCallback renderCallback = this.renderCallback;
        if (renderCallback != null) {
            renderCallback.onSurfaceCreated(this.mSurface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        ITTRenderView.RenderCallback renderCallback = this.renderCallback;
        if (renderCallback != null) {
            renderCallback.onSurfaceChanged(width, height);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        ITTRenderView.RenderCallback renderCallback = this.renderCallback;
        if (renderCallback != null && !this.mEnableSurfaceTextureReuse) {
            renderCallback.onSurfaceDestroyed();
        }
        if (!this.mEnableSurfaceTextureReuse) {
            Surface surface2 = this.mSurface;
            if (surface2 != null) {
                surface2.release();
                this.mSurface = null;
            }
            this.mSurfaceTexture = null;
        }
        return !this.mEnableSurfaceTextureReuse;
    }

    private void reusedSurfaceTexture() {
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 != null && surfaceTexture != surfaceTexture2) {
            setSurfaceTexture(this.mSurfaceTexture);
        }
        this.mEnableSurfaceTextureReuse = false;
    }
}
