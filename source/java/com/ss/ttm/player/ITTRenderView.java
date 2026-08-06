package com.ss.ttm.player;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public interface ITTRenderView {

    /* loaded from: classes7.dex */
    public interface RenderCallback {
        void onSurfaceChanged(int width, int height);

        void onSurfaceCreated(Surface surface);

        void onSurfaceDestroyed();
    }

    /* loaded from: classes7.dex */
    public interface SnapshotCallback {
        void onResult(int result, Bitmap bitmap);
    }

    Surface getSurface();

    View getView();

    void reCreateSurface();

    default void reuse() {
    }

    void setFixedSizeIfNeeded(int width, int height);

    void setRenderCallback(RenderCallback callback);

    void snapshotBitmap(boolean highQuality, SnapshotCallback callback);
}
