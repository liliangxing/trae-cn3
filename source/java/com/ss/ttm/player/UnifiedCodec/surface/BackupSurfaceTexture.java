package com.ss.ttm.player.UnifiedCodec.surface;

import android.graphics.SurfaceTexture;

/* loaded from: classes7.dex */
public final class BackupSurfaceTexture extends SurfaceTexture {
    private Callback mCallback;

    /* loaded from: classes7.dex */
    public interface Callback {
        void onReleased();
    }

    public BackupSurfaceTexture(int texId) {
        super(texId);
    }

    @Override // android.graphics.SurfaceTexture
    public void release() {
        super.release();
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onReleased();
        }
    }

    public final void setCallback(Callback callback) {
        this.mCallback = callback;
    }
}
