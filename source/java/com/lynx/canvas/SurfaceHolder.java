package com.lynx.canvas;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.lynx.canvas.FirstFrameAwareSurfaceTexture;

/* loaded from: classes6.dex */
public class SurfaceHolder implements FirstFrameAwareSurfaceTexture.FirstFrameAvailableListener {
    private static final String TAG = "KryptonSurfaceHolder";
    private FirstFrameListener mFirstFrameListener;
    private int mHeight;
    private long mNativeSurfacePtr;
    private final Surface mSurface;
    private final FirstFrameAwareSurfaceTexture mSurfaceTexture;
    private int mWidth;

    /* loaded from: classes6.dex */
    public interface FirstFrameListener {
        void onFirstFrame();
    }

    private static native long nativeCreateGLSurface(Surface surface, SurfaceTexture surfaceTexture);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceHolder(FirstFrameListener firstFrameListener) {
        FirstFrameAwareSurfaceTexture firstFrameAwareSurfaceTexture = new FirstFrameAwareSurfaceTexture(0);
        this.mSurfaceTexture = firstFrameAwareSurfaceTexture;
        firstFrameAwareSurfaceTexture.detachFromGLContext();
        firstFrameAwareSurfaceTexture.setFirstFrameListener(this);
        Surface surface = new Surface(firstFrameAwareSurfaceTexture);
        this.mSurface = surface;
        this.mFirstFrameListener = firstFrameListener;
        this.mWidth = 1;
        this.mHeight = 1;
        this.mNativeSurfacePtr = nativeCreateGLSurface(surface, firstFrameAwareSurfaceTexture);
        KryptonLLog.i(TAG, "Created with surface texture " + firstFrameAwareSurfaceTexture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initTextureView(TextureView textureView) {
        KryptonLLog.i(TAG, "initTextureView with " + textureView);
        SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
        if (this.mSurfaceTexture.equals(surfaceTexture)) {
            return;
        }
        if (surfaceTexture != null) {
            KryptonLLog.i(TAG, "Init TextureView but it has already another st.");
        }
        textureView.setSurfaceTexture(this.mSurfaceTexture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSurfaceTextureSizeChanged(int i, int i2) {
        if (this.mWidth == i && this.mHeight == i2) {
            return;
        }
        if (i == 0 || i2 == 0) {
            KryptonLLog.w(TAG, "onSurfaceTextureSizeChanged with invalid size " + i + " / " + i2);
        } else {
            this.mWidth = i;
            this.mHeight = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispose() {
        KryptonLLog.i(TAG, "dispose surface texture with " + this.mSurfaceTexture);
        this.mSurface.release();
        this.mFirstFrameListener = null;
    }

    @Override // com.lynx.canvas.FirstFrameAwareSurfaceTexture.FirstFrameAvailableListener
    public void onFirstFrameAvailable() {
        KryptonLLog.i(TAG, "onFirstFrameAvailable mFirstFrameListener " + this.mFirstFrameListener);
        FirstFrameListener firstFrameListener = this.mFirstFrameListener;
        if (firstFrameListener != null) {
            firstFrameListener.onFirstFrame();
        }
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long releaseSurfacePtr() {
        long j = this.mNativeSurfacePtr;
        this.mNativeSurfacePtr = 0L;
        return j;
    }
}
