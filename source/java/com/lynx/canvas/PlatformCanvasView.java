package com.lynx.canvas;

import android.graphics.Rect;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PlatformCanvasView {
    private static final int MAX_POINTER_COUNT = 5;
    private static final String TAG = "PlatformCanvasView";
    private static final int TOUCH_EVENT_BUFFER_SIZE = 112;
    private WeakReference<KryptonApp> mApp;
    private Rect mCurrentRect;
    private int mHeight;
    private String mName;
    private long mNativeCanvasViewPtr;
    private float mScale;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mWidth;
    private Boolean mInitialized = false;
    private boolean mHasNotifySurfaceCreate = false;

    private native long nativeCreateCanvasView(String str, long j, int i, int i2);

    private native void nativeDestroyCanvasView(long j);

    private native void nativeDispatchTouchEvent(long j, ByteBuffer byteBuffer);

    private native void nativeOnSurfaceChanged(long j, int i, int i2);

    private native void nativeOnSurfaceCreated(long j, long j2, int i, int i2, int i3);

    private native void nativeOnSurfaceDestroyed(long j);

    private native void nativeViewLayoutUpdate(long j, int i, int i2, int i3, int i4, int i5, int i6);

    public boolean setup(String str, KryptonApp kryptonApp, float f, int i, int i2) {
        if (this.mInitialized.booleanValue()) {
            KryptonLLog.m2560e(TAG, "Set name to initialized canvas with old name " + this.mName + " new name " + str);
            return true;
        }
        this.mScale = f;
        this.mName = str;
        this.mWidth = i;
        this.mHeight = i2;
        this.mApp = new WeakReference<>(kryptonApp);
        if (!initInternal()) {
            KryptonLLog.m2560e(TAG, "init canvas internal failed " + str);
            return false;
        }
        this.mInitialized = true;
        return true;
    }

    private boolean initInternal() {
        if (!Krypton.inst().hasInitialized()) {
            KryptonLLog.m2563w(TAG, "initCanvasInternal but krypton do not init.");
            return false;
        }
        KryptonApp kryptonApp = this.mApp.get();
        if (kryptonApp == null) {
            KryptonLLog.m2563w(TAG, "krypton app has been released.");
            return false;
        }
        long newNativeWeakPtr = kryptonApp.newNativeWeakPtr();
        if (newNativeWeakPtr == 0) {
            KryptonLLog.m2563w(TAG, "canvas app has been destroyed.");
            return false;
        }
        this.mNativeCanvasViewPtr = nativeCreateCanvasView(this.mName, newNativeWeakPtr, this.mWidth, this.mHeight);
        return true;
    }

    public void notifySurfaceChanged(long j, int i, int i2) {
        notifySurfaceChangedWithScaleMode(j, i, i2, SurfaceScaleMode.SCALE_TO_FILL);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifySurfaceChangedWithScaleMode(long j, int i, int i2, SurfaceScaleMode surfaceScaleMode) {
        synchronized (this) {
            if (i == 0 || i2 == 0) {
                KryptonLLog.m2561i(TAG, "ignore notify surface changed w " + i + " h " + i2 + " or platform view disposed");
                return;
            }
            if (!this.mHasNotifySurfaceCreate) {
                KryptonLLog.m2561i(TAG, "notify surface created w " + i + " h " + i2 + " scaleMode " + surfaceScaleMode);
                this.mSurfaceWidth = i;
                this.mSurfaceHeight = i2;
                onSurfaceCreated(j, i, i2, surfaceScaleMode);
                return;
            }
            if (this.mSurfaceWidth == i && this.mSurfaceHeight == i2) {
                return;
            }
            KryptonLLog.m2561i(TAG, "notify surface changed w " + i + " h " + i2);
            this.mSurfaceWidth = i;
            this.mSurfaceHeight = i2;
            onSurfaceChanged(i, i2);
        }
    }

    private void onSurfaceCreated(long j, int i, int i2, SurfaceScaleMode surfaceScaleMode) {
        if (i == 0 || i2 == 0) {
            KryptonLLog.m2561i(TAG, "ignore notify surface created w " + i + " h " + i2);
            return;
        }
        long j2 = this.mNativeCanvasViewPtr;
        if (j2 == 0 || j == 0) {
            KryptonLLog.m2560e(TAG, "surface created but mNativeCanvasViewPtr " + this.mNativeCanvasViewPtr + " glSurfacePtr " + j);
        } else {
            this.mHasNotifySurfaceCreate = true;
            nativeOnSurfaceCreated(j2, j, i, i2, surfaceScaleMode.value);
        }
    }

    private void onSurfaceChanged(int i, int i2) {
        long j = this.mNativeCanvasViewPtr;
        if (j == 0) {
            KryptonLLog.m2560e(TAG, "surface changed but mNativeCanvasViewPtr " + this.mNativeCanvasViewPtr);
        } else {
            nativeOnSurfaceChanged(j, i, i2);
        }
    }

    public void onSurfaceDestroyed() {
        long j = this.mNativeCanvasViewPtr;
        if (j == 0) {
            return;
        }
        this.mHasNotifySurfaceCreate = false;
        nativeOnSurfaceDestroyed(j);
    }

    public void dispose() {
        long j = this.mNativeCanvasViewPtr;
        if (j == 0) {
            return;
        }
        this.mNativeCanvasViewPtr = 0L;
        nativeDestroyCanvasView(j);
    }

    public void dispatchTouchEvent(MotionEvent motionEvent, Rect rect, Rect rect2) {
        int actionIndex = motionEvent.getActionIndex();
        if (actionIndex >= 5) {
            return;
        }
        int pointerCount = motionEvent.getPointerCount();
        int i = pointerCount <= 5 ? pointerCount : 5;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(112);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.clear();
        allocateDirect.put((byte) motionEvent.getActionMasked()).put((byte) i).put((byte) actionIndex).put((byte) 1).putInt(px2dip(rect2.left)).putInt(px2dip(rect2.top));
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        for (int i2 = 0; i2 < i; i2++) {
            allocateDirect.putInt(motionEvent.getPointerId(i2)).putFloat(((rect.left - rect2.left) + motionEvent.getX(i2)) / this.mScale).putFloat(((rect.top - rect2.top) + motionEvent.getY(i2)) / this.mScale).putFloat((motionEvent.getX(i2) + rawX) / this.mScale).putFloat((motionEvent.getY(i2) + rawY) / this.mScale);
        }
        long j = this.mNativeCanvasViewPtr;
        if (j != 0) {
            nativeDispatchTouchEvent(j, allocateDirect);
        }
    }

    public void notifyLayoutUpdate(Rect rect, int i, int i2) {
        synchronized (this) {
            if (rect.equals(this.mCurrentRect) && this.mWidth == i && this.mHeight == i2) {
                return;
            }
            this.mCurrentRect = rect;
            this.mWidth = i;
            this.mHeight = i2;
            long j = this.mNativeCanvasViewPtr;
            if (j != 0) {
                nativeViewLayoutUpdate(j, rect.left, this.mCurrentRect.right, this.mCurrentRect.top, this.mCurrentRect.bottom, this.mWidth, this.mHeight);
            }
        }
    }

    private int px2dip(float f) {
        return (int) ((f / this.mScale) + 0.5f);
    }
}
