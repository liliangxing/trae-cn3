package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalVideoCaptureConfig {
    public int capturePreference;
    public int frameRate;
    public int height;
    public int width;

    public InternalVideoCaptureConfig(int mode, int w, int h, int fps) {
        this.capturePreference = mode;
        this.width = w;
        this.height = h;
        this.frameRate = fps;
    }

    public int getCapturePreference() {
        return this.capturePreference;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getFrameRate() {
        return this.frameRate;
    }
}
