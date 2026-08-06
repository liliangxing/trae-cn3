package com.lynx.canvas;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class KryptonViewAdaptor {
    private static final String TAG = "KryptonViewAdaptor";
    private long mNativeSurfacePtr;
    private PlatformCanvasView mPlatformCanvasView;
    private final SurfaceScaleMode mSurfaceScaleMode;
    private WeakReference<KryptonSurfaceView> mSurfaceView;

    /* JADX INFO: Access modifiers changed from: private */
    public native long nativeCreateSurface(Surface surface);

    private KryptonViewAdaptor(SurfaceScaleMode surfaceScaleMode) {
        this.mSurfaceScaleMode = surfaceScaleMode;
    }

    public static KryptonViewAdaptor from(SurfaceView surfaceView) {
        return from(surfaceView, SurfaceScaleMode.SCALE_TO_FILL);
    }

    public static KryptonViewAdaptor from(final SurfaceView surfaceView, SurfaceScaleMode surfaceScaleMode) {
        return from(new KryptonSurfaceView() { // from class: com.lynx.canvas.KryptonViewAdaptor.1
            @Override // com.lynx.canvas.KryptonSurfaceView
            public int getWidth() {
                return surfaceView.getWidth();
            }

            @Override // com.lynx.canvas.KryptonSurfaceView
            public int getHeight() {
                return surfaceView.getHeight();
            }

            @Override // com.lynx.canvas.KryptonSurfaceView
            public android.view.SurfaceHolder getHolder() {
                return surfaceView.getHolder();
            }

            @Override // com.lynx.canvas.KryptonSurfaceView
            public void setOnTouchListener(View.OnTouchListener onTouchListener) {
                surfaceView.setOnTouchListener(onTouchListener);
            }

            @Override // com.lynx.canvas.KryptonSurfaceView
            public float getDensity() {
                return surfaceView.getContext().getResources().getDisplayMetrics().density;
            }
        }, surfaceScaleMode);
    }

    public static KryptonViewAdaptor from(final KryptonSurfaceView kryptonSurfaceView, SurfaceScaleMode surfaceScaleMode) {
        if (kryptonSurfaceView == null) {
            KryptonLLog.m2561i(TAG, "surface view should not be null");
            return null;
        }
        final KryptonViewAdaptor kryptonViewAdaptor = new KryptonViewAdaptor(surfaceScaleMode);
        kryptonViewAdaptor.mSurfaceView = new WeakReference<>(kryptonSurfaceView);
        kryptonViewAdaptor.mPlatformCanvasView = new PlatformCanvasView();
        kryptonSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.lynx.canvas.KryptonViewAdaptor.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
                synchronized (KryptonViewAdaptor.this) {
                    KryptonLLog.m2561i(KryptonViewAdaptor.TAG, "surfaceCreated, holder: " + surfaceHolder + " with surface mode: " + KryptonViewAdaptor.this.mSurfaceScaleMode.value);
                    KryptonViewAdaptor kryptonViewAdaptor2 = KryptonViewAdaptor.this;
                    kryptonViewAdaptor2.mNativeSurfacePtr = kryptonViewAdaptor2.nativeCreateSurface(surfaceHolder.getSurface());
                    KryptonSurfaceView kryptonSurfaceView2 = (KryptonSurfaceView) KryptonViewAdaptor.this.mSurfaceView.get();
                    if (kryptonSurfaceView2 != null) {
                        KryptonViewAdaptor.this.mPlatformCanvasView.notifySurfaceChangedWithScaleMode(KryptonViewAdaptor.this.mNativeSurfacePtr, kryptonSurfaceView2.getWidth(), kryptonSurfaceView2.getHeight(), KryptonViewAdaptor.this.mSurfaceScaleMode);
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                synchronized (KryptonViewAdaptor.this) {
                    KryptonLLog.m2561i(KryptonViewAdaptor.TAG, "surfaceChanged, holder: " + surfaceHolder + ", format: " + i + ", width: " + i2 + ", height:" + i3);
                    KryptonViewAdaptor.this.mPlatformCanvasView.notifySurfaceChangedWithScaleMode(KryptonViewAdaptor.this.mNativeSurfacePtr, i2, i3, KryptonViewAdaptor.this.mSurfaceScaleMode);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
                synchronized (KryptonViewAdaptor.this) {
                    KryptonLLog.m2561i(KryptonViewAdaptor.TAG, "surfaceDestroyed, holder: " + surfaceHolder);
                    KryptonViewAdaptor.this.mPlatformCanvasView.onSurfaceDestroyed();
                    KryptonViewAdaptor.this.mNativeSurfacePtr = 0L;
                }
            }
        });
        kryptonSurfaceView.setOnTouchListener(new View.OnTouchListener() { // from class: com.lynx.canvas.KryptonViewAdaptor.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && view != null && view.getParent() != null) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                int width = KryptonSurfaceView.this.getWidth();
                int height = KryptonSurfaceView.this.getHeight();
                kryptonViewAdaptor.mPlatformCanvasView.dispatchTouchEvent(motionEvent, new Rect(0, 0, width, height), new Rect(0, 0, width, height));
                return true;
            }
        });
        return kryptonViewAdaptor;
    }

    public void setup(String str, KryptonApp kryptonApp) {
        KryptonSurfaceView kryptonSurfaceView = this.mSurfaceView.get();
        if (kryptonSurfaceView == null) {
            KryptonLLog.m2560e(TAG, "ignore setup, surfaceView has been released");
            return;
        }
        this.mPlatformCanvasView.setup(str, kryptonApp, kryptonSurfaceView.getDensity(), kryptonSurfaceView.getWidth(), kryptonSurfaceView.getHeight());
        Surface surface = kryptonSurfaceView.getHolder().getSurface();
        synchronized (this) {
            if (this.mNativeSurfacePtr == 0 && surface != null && surface.isValid()) {
                KryptonLLog.m2561i(TAG, "create surface for surfaceCreated event missed.");
                this.mNativeSurfacePtr = nativeCreateSurface(surface);
            }
            this.mPlatformCanvasView.notifySurfaceChangedWithScaleMode(this.mNativeSurfacePtr, kryptonSurfaceView.getWidth(), kryptonSurfaceView.getHeight(), this.mSurfaceScaleMode);
        }
    }

    public void notifyLayoutUpdate(Rect rect) {
        if (this.mSurfaceView.get() == null) {
            KryptonLLog.m2560e(TAG, "ignore layout update, surfaceView has been released");
        } else {
            this.mPlatformCanvasView.notifyLayoutUpdate(rect, rect.right - rect.left, rect.bottom - rect.top);
        }
    }

    public void dispose() {
        this.mPlatformCanvasView.dispose();
    }
}
