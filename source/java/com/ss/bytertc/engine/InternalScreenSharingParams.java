package com.ss.bytertc.engine;

import com.ss.bytertc.engine.video.ScreenSharingParameters;

/* loaded from: classes7.dex */
public class InternalScreenSharingParams {
    public int bitrate;
    public int frameRate;
    public int maxHeight;
    public int maxWidth;
    public int minBitrate;

    public InternalScreenSharingParams(ScreenSharingParameters params) {
        this.maxWidth = 0;
        this.maxHeight = 0;
        this.frameRate = 15;
        this.bitrate = -1;
        this.minBitrate = 0;
        if (params != null) {
            this.maxHeight = params.maxHeight;
            this.maxWidth = params.maxWidth;
            this.frameRate = params.frameRate;
            this.bitrate = params.bitrate;
            this.minBitrate = params.minBitrate;
        }
    }

    public InternalScreenSharingParams(int width, int height, int frameRate, int bitrate, int minBitrate) {
        this.maxHeight = height;
        this.maxWidth = width;
        this.frameRate = frameRate;
        this.bitrate = bitrate;
        this.minBitrate = minBitrate;
    }

    public int getWidth() {
        return this.maxWidth;
    }

    public int getHeight() {
        return this.maxHeight;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getMinBitrate() {
        return this.minBitrate;
    }
}
