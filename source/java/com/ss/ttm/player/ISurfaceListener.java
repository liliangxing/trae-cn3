package com.ss.ttm.player;

import android.view.SurfaceHolder;

/* loaded from: classes7.dex */
public interface ISurfaceListener {
    void onSurfaceChanged(SurfaceHolder holder);

    void onSurfaceCreated(SurfaceHolder holder);

    void onSurfaceDestroyed(SurfaceHolder holder);
}
