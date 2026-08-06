package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public class VideoPreset {
    private int bandwidth;
    private int fps;
    private int height;
    private int width;

    public VideoPreset(int width, int height, int fps, int bw) {
        this.width = width;
        this.height = height;
        this.fps = fps;
        this.bandwidth = bw;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getFps() {
        return this.fps;
    }

    public int getBandwidth() {
        return this.bandwidth;
    }
}
