package com.lynx.canvas;

import android.graphics.RectF;
import android.os.Looper;
import android.view.Surface;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class KryptonDownStreamManager {
    private static final String TAG = "KryptonDownStreamManager";

    private static native long nativeAddSurface(long j, String str, Surface surface, int i, int i2, int i3, float f, float f2, float f3, float f4, int i4);

    private static native void nativeRemoveSurface(long j, String str, long j2);

    public long addDownStreamSurface(KryptonApp kryptonApp, String str, Surface surface, int i, int i2, SurfaceScaleMode surfaceScaleMode, RectF rectF, int i3) {
        long newNativeWeakPtr = kryptonApp.newNativeWeakPtr();
        if (newNativeWeakPtr == 0) {
            KryptonLLog.m2560e(TAG, "canvas app weak ptr is nullptr.");
            return 0L;
        }
        if (surfaceScaleMode != SurfaceScaleMode.SCALE_TO_FILL_WITH_SOURCE_CROP) {
            return nativeAddSurface(newNativeWeakPtr, str, surface, i, i2, surfaceScaleMode.value, 0.0f, 0.0f, 0.0f, 0.0f, i3);
        }
        if (rectF == null) {
            throw new IllegalArgumentException("sourceRect must be passed if use SCALE_TO_FILL_WITH_SOURCE_CROP");
        }
        return nativeAddSurface(newNativeWeakPtr, str, surface, i, i2, surfaceScaleMode.value, rectF.left, (1.0f - rectF.top) - rectF.height(), rectF.width(), rectF.height(), i3);
    }

    public long addDownStreamSurface(KryptonApp kryptonApp, String str, Surface surface, int i, int i2, SurfaceScaleMode surfaceScaleMode, RectF rectF) {
        return addDownStreamSurface(kryptonApp, str, surface, i, i2, surfaceScaleMode, rectF, 0);
    }

    public void removeDownStreamSurface(KryptonApp kryptonApp, String str, long j) {
        long newNativeWeakPtr = kryptonApp.newNativeWeakPtr();
        if (newNativeWeakPtr == 0) {
            KryptonLLog.m2560e(TAG, "canvas app weak ptr is nullptr.");
        } else {
            nativeRemoveSurface(newNativeWeakPtr, str, j);
        }
    }

    public static KryptonDownStreamManager getInstance() {
        return Holder.INSTANCE;
    }

    private KryptonDownStreamManager() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("KryptonDownStreamManager should be used on main thread only.");
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class Holder {
        private static final KryptonDownStreamManager INSTANCE = new KryptonDownStreamManager();

        private Holder() {
        }
    }
}
