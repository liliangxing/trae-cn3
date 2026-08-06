package com.lynx.canvas;

import android.view.View;

/* loaded from: classes6.dex */
public interface KryptonSurfaceView {
    float getDensity();

    int getHeight();

    android.view.SurfaceHolder getHolder();

    int getWidth();

    void setOnTouchListener(View.OnTouchListener onTouchListener);
}
