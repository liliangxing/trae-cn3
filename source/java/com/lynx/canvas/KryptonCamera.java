package com.lynx.canvas;

import android.graphics.SurfaceTexture;

/* loaded from: classes6.dex */
public interface KryptonCamera {

    /* loaded from: classes6.dex */
    public static class Config {
        public static final String RESOLUTION_HIGH = "high";
        public static final String RESOLUTION_LOW = "low";
        public static final String RESOLUTION_MEDIUM = "medium";
        public boolean autoFocus;
        public String extraJson;
        public String faceMode;
        public String resolution;
        public CustomSize size;
    }

    void focus();

    int getHeight();

    int getWidth();

    void pause();

    void play();

    void release();

    boolean requestWithConfig(Config config);

    void setupPreviewTexture(SurfaceTexture surfaceTexture);

    /* loaded from: classes6.dex */
    public static class CustomSize {
        public int height;
        public int width;

        public CustomSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }
}
