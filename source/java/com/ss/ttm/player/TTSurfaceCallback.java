package com.ss.ttm.player;

import android.view.SurfaceHolder;
import com.ss.ttm.utils.AVLogger;

/* loaded from: classes7.dex */
public class TTSurfaceCallback implements SurfaceHolder.Callback {
    private static final String TAG = "TTSurfaceCallback";
    private ISurfaceListener mListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTSurfaceCallback(ISurfaceListener player) {
        this.mListener = player;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        AVLogger.d(TAG, "surface is changed");
        ISurfaceListener iSurfaceListener = this.mListener;
        if (iSurfaceListener != null) {
            iSurfaceListener.onSurfaceChanged(holder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        AVLogger.d(TAG, "surface is destroyed");
        ISurfaceListener iSurfaceListener = this.mListener;
        if (iSurfaceListener != null) {
            iSurfaceListener.onSurfaceDestroyed(holder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        AVLogger.d(TAG, "surface is create");
        ISurfaceListener iSurfaceListener = this.mListener;
        if (iSurfaceListener != null) {
            iSurfaceListener.onSurfaceCreated(holder);
        }
    }
}
