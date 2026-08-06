package com.lynx.canvas;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import android.view.Surface;

/* loaded from: classes6.dex */
public class SurfaceTextureWrapper {
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;

    public SurfaceTextureWrapper(int i, int i2, int i3) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(i);
        this.mSurfaceTexture = surfaceTexture;
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(i2, i3);
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public Surface getSurface() {
        if (this.mSurface == null) {
            this.mSurface = new Surface(this.mSurfaceTexture);
        }
        return this.mSurface;
    }

    public static SurfaceTextureWrapper create(int i, int i2, int i3) {
        return new SurfaceTextureWrapper(i, i2, i3);
    }

    float[] updateTexture() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        surfaceTexture.updateTexImage();
        float[] fArr = new float[16];
        this.mSurfaceTexture.getTransformMatrix(fArr);
        return fArr;
    }

    double getTimestamp() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return 0.0d;
        }
        long timestamp = surfaceTexture.getTimestamp();
        long abs = Math.abs(System.nanoTime() - timestamp);
        long abs2 = Math.abs(SystemClock.elapsedRealtimeNanos() - timestamp);
        return r2 - Math.min(Math.min(abs, abs2), Math.abs((SystemClock.uptimeMillis() * 1000000) - timestamp));
    }

    void release() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
        }
    }
}
