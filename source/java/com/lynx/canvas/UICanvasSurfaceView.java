package com.lynx.canvas;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.lynx.tasm.base.LLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UICanvasSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "KryptonUISurfaceView";
    private long mNativeSurfacePtr;
    private PlatformCanvasView mPlatformCanvasView;
    private final float mRatio;

    private native long nativeCreateSurface(Surface surface);

    public UICanvasSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        setZOrderOnTop(true);
        getHolder().setFormat(1);
        this.mRatio = context.getResources().getDisplayMetrics().density;
        this.mPlatformCanvasView = new PlatformCanvasView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setup(String str, KryptonApp kryptonApp) {
        this.mPlatformCanvasView.setup(str, kryptonApp, this.mRatio, getWidth(), getHeight());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
        LLog.m2578i(TAG, "surfaceCreated " + surfaceHolder);
        this.mNativeSurfacePtr = nativeCreateSurface(surfaceHolder.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        LLog.m2578i(TAG, "surfaceChanged " + surfaceHolder + " " + i + " " + i2 + " " + i3);
        this.mPlatformCanvasView.notifySurfaceChanged(this.mNativeSurfacePtr, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
        LLog.m2578i(TAG, "surfaceDestroyed " + surfaceHolder);
        this.mPlatformCanvasView.onSurfaceDestroyed();
        this.mNativeSurfacePtr = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyLayout(Rect rect) {
        LLog.m2578i(TAG, "notifyLayout " + rect);
        PlatformCanvasView platformCanvasView = this.mPlatformCanvasView;
        if (platformCanvasView == null) {
            return;
        }
        platformCanvasView.notifyLayoutUpdate(rect, getWidth(), getHeight());
    }

    public boolean dispatchTouch(MotionEvent motionEvent, Rect rect, Rect rect2) {
        PlatformCanvasView platformCanvasView = this.mPlatformCanvasView;
        if (platformCanvasView == null) {
            return false;
        }
        platformCanvasView.dispatchTouchEvent(motionEvent, rect, rect2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        LLog.m2578i(TAG, "UICanvasSurfaceView destroy");
        PlatformCanvasView platformCanvasView = this.mPlatformCanvasView;
        if (platformCanvasView != null) {
            platformCanvasView.onSurfaceDestroyed();
            this.mPlatformCanvasView.dispose();
            this.mPlatformCanvasView = null;
        }
    }
}
