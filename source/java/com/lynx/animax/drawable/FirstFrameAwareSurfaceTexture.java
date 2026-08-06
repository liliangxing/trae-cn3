package com.lynx.animax.drawable;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class FirstFrameAwareSurfaceTexture extends SurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "AnimaXFirstFrameAwareSurfaceTexture";
    private WeakReference<FirstFrameAvailableListener> mCustomFirstFrameAvailableListener;
    private boolean mFirstFrameHasPassed;
    private boolean mHasFinalized;
    private boolean mIsReleased;
    private final Handler mMainThreadHandler;
    private Handler mOnFrameAvailableHandler;
    private WeakReference<Surface> mSurface;
    private WeakReference<TextureView> mTextureView;

    /* loaded from: classes6.dex */
    public interface FirstFrameAvailableListener {
        void onFirstFrameAvailable();
    }

    private long getSurfaceTextureField() {
        try {
            Field declaredField = SurfaceTexture.class.getDeclaredField("mSurfaceTexture");
            declaredField.setAccessible(true);
            return declaredField.getLong(this);
        } catch (Throwable th) {
            AnimaXLog.e(TAG, "fail to getSurfaceTextureField: " + th.getMessage());
            return -1L;
        }
    }

    public FirstFrameAwareSurfaceTexture() {
        super(0);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mHasFinalized = false;
        this.mIsReleased = false;
        super.setOnFrameAvailableListener(this, UIThreadUtils.getUiThreadHandler());
    }

    public synchronized Surface getSurface() {
        WeakReference<Surface> weakReference;
        weakReference = this.mSurface;
        return weakReference != null ? weakReference.get() : null;
    }

    public synchronized void setSurface(Surface surface) {
        this.mSurface = new WeakReference<>(surface);
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        setOnFrameAvailableListenerInternal(onFrameAvailableListener, null);
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        setOnFrameAvailableListenerInternal(onFrameAvailableListener, handler);
        clearInternalFrameRateListenerAsync();
    }

    private void setOnFrameAvailableListenerInternal(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        updateTextureLayerIfNecessary(onFrameAvailableListener);
        if (onFrameAvailableListener != null) {
            this.mOnFrameAvailableHandler = new OnFrameAvailableHandler(handler != null ? handler.getLooper() : Looper.getMainLooper(), this, onFrameAvailableListener);
        } else {
            this.mOnFrameAvailableHandler = null;
        }
    }

    private void updateTextureLayerIfNecessary(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        if (Build.VERSION.SDK_INT < 25 || onFrameAvailableListener == null || this.mOnFrameAvailableHandler == null) {
            return;
        }
        WeakReference<TextureView> weakReference = this.mTextureView;
        final TextureView textureView = weakReference != null ? weakReference.get() : null;
        if (textureView == null) {
            return;
        }
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FirstFrameAwareSurfaceTexture.lambda$updateTextureLayerIfNecessary$0(textureView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateTextureLayerIfNecessary$0(TextureView textureView) {
        AnimaXLog.i(TAG, "Triggering layer update via opacity toggle");
        boolean isOpaque = textureView.isOpaque();
        textureView.setOpaque(!isOpaque);
        textureView.setOpaque(isOpaque);
    }

    public void setTextureView(TextureView textureView) {
        this.mTextureView = new WeakReference<>(textureView);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Handler handler = this.mOnFrameAvailableHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(0);
            obtainMessage.setAsynchronous(true);
            this.mOnFrameAvailableHandler.sendMessage(obtainMessage);
        }
        if (this.mFirstFrameHasPassed) {
            return;
        }
        this.mFirstFrameHasPassed = true;
        WeakReference<FirstFrameAvailableListener> weakReference = this.mCustomFirstFrameAvailableListener;
        FirstFrameAvailableListener firstFrameAvailableListener = weakReference != null ? weakReference.get() : null;
        AnimaXLog.i(TAG, "trigger first frame callback with " + firstFrameAvailableListener);
        if (firstFrameAvailableListener != null) {
            firstFrameAvailableListener.onFirstFrameAvailable();
        }
    }

    public void setFirstFrameListener(FirstFrameAvailableListener firstFrameAvailableListener) {
        this.mCustomFirstFrameAvailableListener = new WeakReference<>(firstFrameAvailableListener);
        if (this.mFirstFrameHasPassed) {
            firstFrameAvailableListener.onFirstFrameAvailable();
        }
    }

    private void clearInternalFrameRateListenerAsync() {
        if (Build.VERSION.SDK_INT < 35) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this);
        AnimaXLog.i(TAG, "clearInternalFrameRateListenerAsync: Posting cleanup action");
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FirstFrameAwareSurfaceTexture.lambda$clearInternalFrameRateListenerAsync$1(weakReference);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$clearInternalFrameRateListenerAsync$1(WeakReference weakReference) {
        FirstFrameAwareSurfaceTexture firstFrameAwareSurfaceTexture = (FirstFrameAwareSurfaceTexture) weakReference.get();
        if (firstFrameAwareSurfaceTexture != null) {
            AnimaXLog.i(TAG, "clearInternalFrameRateListenerAsync: Executing cleanup");
            firstFrameAwareSurfaceTexture.setNullOnSetFrameRateListener();
        } else {
            AnimaXLog.i(TAG, "clearInternalFrameRateListenerAsync: Skipped, reference lost");
        }
    }

    private void setNullOnSetFrameRateListener() {
        if (Build.VERSION.SDK_INT < 35) {
            return;
        }
        if (isOnSetFrameRateHandlerNull()) {
            AnimaXLog.i(TAG, "setNullOnSetFrameRateListener fail, handler is already null.");
            return;
        }
        try {
            Method method = SurfaceTexture.class.getMethod("setOnSetFrameRateListener", Class.forName("android.graphics.SurfaceTexture$OnSetFrameRateListener"), Handler.class);
            method.setAccessible(true);
            method.invoke(this, null, null);
            AnimaXLog.i(TAG, "setNullOnSetFrameRateListener result: " + isOnSetFrameRateHandlerNull());
        } catch (Throwable th) {
            AnimaXLog.e(TAG, "setNullOnSetFrameRateListener fail: " + th.getMessage());
        }
    }

    private boolean isOnSetFrameRateHandlerNull() {
        try {
            Field declaredField = SurfaceTexture.class.getDeclaredField("mOnSetFrameRateHandler");
            declaredField.setAccessible(true);
            return declaredField.get(this) == null;
        } catch (Throwable th) {
            AnimaXLog.e(TAG, "isOnSetFrameRateHandlerNull fail: " + th.getMessage());
            return false;
        }
    }

    @Override // android.graphics.SurfaceTexture
    public synchronized void release() {
        AnimaXLog.i(TAG, "release with " + this);
        if (this.mHasFinalized) {
            AnimaXLog.w(TAG, "release() called after finalize(). Skip releasing SurfaceTexture. " + this);
            return;
        }
        if (this.mIsReleased) {
            AnimaXLog.w(TAG, "release() called multiple times. " + this);
            return;
        }
        this.mIsReleased = true;
        Surface surface = getSurface();
        if (surface != null && surface.isValid()) {
            surface.release();
            AnimaXLog.i(TAG, "release Surface: " + surface);
            setSurface(null);
        }
        if (Build.VERSION.SDK_INT >= 26 && isReleased()) {
            AnimaXLog.w(TAG, "already released: " + this);
        } else if (getSurfaceTextureField() == 0) {
            AnimaXLog.i(TAG, "surfaceTextureField is 0, skip release");
        } else {
            AnimaXLog.i(TAG, "release SurfaceTexture: " + this);
            super.release();
        }
    }

    @Override // android.graphics.SurfaceTexture
    protected synchronized void finalize() throws Throwable {
        this.mHasFinalized = true;
        Surface surface = getSurface();
        if (surface != null && surface.isValid()) {
            surface.release();
            AnimaXLog.i(TAG, "release Surface in finalize: " + surface);
            setSurface(null);
        }
        AnimaXLog.i(TAG, "FirstFrameAwareSurfaceTexture finalize: " + this);
        super.finalize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class OnFrameAvailableHandler extends Handler {
        private final WeakReference<SurfaceTexture.OnFrameAvailableListener> mWeakListener;
        private final WeakReference<FirstFrameAwareSurfaceTexture> mWeakSurfaceTexture;

        public OnFrameAvailableHandler(Looper looper, FirstFrameAwareSurfaceTexture firstFrameAwareSurfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
            super(looper);
            this.mWeakSurfaceTexture = new WeakReference<>(firstFrameAwareSurfaceTexture);
            this.mWeakListener = new WeakReference<>(onFrameAvailableListener);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener;
            FirstFrameAwareSurfaceTexture firstFrameAwareSurfaceTexture = this.mWeakSurfaceTexture.get();
            if (firstFrameAwareSurfaceTexture == null || (onFrameAvailableListener = this.mWeakListener.get()) == null) {
                return;
            }
            onFrameAvailableListener.onFrameAvailable(firstFrameAwareSurfaceTexture);
        }
    }
}
