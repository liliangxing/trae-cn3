package com.lynx.canvas;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes6.dex */
public class FirstFrameAwareSurfaceTexture extends SurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "KryptonFirstFrameAwareSurfaceTexture";
    private FirstFrameAvailableListener mCustomFirstFrameAvailableListener;
    private boolean mFirstFrameHasPassed;
    private Handler mOnFrameAvailableHandler;

    /* loaded from: classes6.dex */
    public interface FirstFrameAvailableListener {
        void onFirstFrameAvailable();
    }

    public FirstFrameAwareSurfaceTexture(int i) {
        super(i);
        setupFirstFrameAvailableListenerInternal();
    }

    private void setupFirstFrameAvailableListenerInternal() {
        super.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        setOnFrameAvailableListenerInternal(onFrameAvailableListener, null);
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        setOnFrameAvailableListenerInternal(onFrameAvailableListener, handler);
    }

    private void setOnFrameAvailableListenerInternal(final SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        Handler.Callback callback = null;
        if (onFrameAvailableListener != null) {
            this.mOnFrameAvailableHandler = new Handler(handler != null ? handler.getLooper() : Looper.getMainLooper(), callback) { // from class: com.lynx.canvas.FirstFrameAwareSurfaceTexture.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    onFrameAvailableListener.onFrameAvailable(FirstFrameAwareSurfaceTexture.this);
                }
            };
        } else {
            this.mOnFrameAvailableHandler = null;
        }
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
        KryptonLLog.i(TAG, "trigger first frame callback with " + this.mCustomFirstFrameAvailableListener);
        FirstFrameAvailableListener firstFrameAvailableListener = this.mCustomFirstFrameAvailableListener;
        if (firstFrameAvailableListener != null) {
            firstFrameAvailableListener.onFirstFrameAvailable();
        }
    }

    public void setFirstFrameListener(FirstFrameAvailableListener firstFrameAvailableListener) {
        this.mCustomFirstFrameAvailableListener = firstFrameAvailableListener;
        if (this.mFirstFrameHasPassed) {
            firstFrameAvailableListener.onFirstFrameAvailable();
        }
    }

    @Override // android.graphics.SurfaceTexture
    public void release() {
        KryptonLLog.i(TAG, "release with " + this);
        super.release();
    }
}
