package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public class ScreenSharingParameters {
    public int bitrate;
    public int frameRate;
    public int maxHeight;
    public int maxWidth;
    public int minBitrate;

    public ScreenSharingParameters() {
        this.maxWidth = 0;
        this.maxHeight = 0;
        this.frameRate = 15;
        this.bitrate = -1;
        this.minBitrate = 0;
    }

    public ScreenSharingParameters(int width, int height, int frameRate, int bitrate, int minBitrate) {
        this.maxHeight = height;
        this.maxWidth = width;
        this.frameRate = frameRate;
        this.bitrate = bitrate;
        this.minBitrate = minBitrate;
    }
}
