package com.lynx.canvas;

import android.os.Looper;
import android.view.Surface;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxCanvasDownStreamManager {
    private static final String TAG = "KryptonDownStreamMgr";

    private static native long nativeAddSurface(long j, String str, Surface surface, int i, int i2, int i3);

    private static native void nativeRemoveSurface(long j, String str, long j2);

    public long addDownStreamSurface(LynxView lynxView, String str, Surface surface, int i, int i2, int i3) {
        long newNativeCanvasAppWeakPtr = newNativeCanvasAppWeakPtr(lynxView);
        if (newNativeCanvasAppWeakPtr == 0) {
            KryptonLLog.m2560e(TAG, "canvas app weak ptr is nullptr.");
            return 0L;
        }
        return nativeAddSurface(newNativeCanvasAppWeakPtr, str, surface, i, i2, i3);
    }

    public long AddDownStreamSurface(LynxView lynxView, String str, Surface surface, int i, int i2) {
        return addDownStreamSurface(lynxView, str, surface, i, i2, 0);
    }

    public void RemoveDownStreamSurface(LynxView lynxView, String str, long j) {
        long newNativeCanvasAppWeakPtr = newNativeCanvasAppWeakPtr(lynxView);
        if (newNativeCanvasAppWeakPtr == 0) {
            KryptonLLog.m2560e(TAG, "canvas app weak ptr is nullptr.");
        } else {
            nativeRemoveSurface(newNativeCanvasAppWeakPtr, str, j);
        }
    }

    private long newNativeCanvasAppWeakPtr(LynxView lynxView) {
        LynxKryptonHelper lynxKryptonHelper = LynxKryptonUtils.getLynxKryptonHelper(lynxView);
        if (lynxKryptonHelper == null) {
            KryptonLLog.m2560e(TAG, "LynxView may be not inited / destroyed or current card do not enable canvas.");
            return 0L;
        }
        return lynxKryptonHelper.getCanvasManager().newNativeCanvasAppWeakPtr();
    }

    public static LynxCanvasDownStreamManager getInstance() {
        return Holder.INSTANCE;
    }

    private LynxCanvasDownStreamManager() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("CanvasDownStreamSurfaceManager should be used on main thread only.");
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class Holder {
        private static final LynxCanvasDownStreamManager INSTANCE = new LynxCanvasDownStreamManager();

        private Holder() {
        }
    }
}
