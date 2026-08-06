package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class SubscribeVideoBaseline {
    public int acceptableBadVideoFpsBaseline;
    public int acceptableBadVideoPixelBaseline;
    public int acceptableGoodVideoFpsBaseline;
    public int acceptableGoodVideoPixelBaseline;
    public int acceptableMinVideoResolutionHeight;
    public int acceptableMinVideoResolutionWidth;
    public int streamPriority;

    public SubscribeVideoBaseline(int acceptableGoodVideoPixelBaseline, int acceptableGoodVideoFpsBaseline, int acceptableBadVideoPixelBaseline, int acceptableBadVideoFpsBaseline, int acceptableMinVideoResolutionWidth, int acceptableMinVideoResolutionHeight, int streamPriority) {
        this.acceptableGoodVideoPixelBaseline = acceptableGoodVideoPixelBaseline;
        this.acceptableGoodVideoFpsBaseline = acceptableGoodVideoFpsBaseline;
        this.acceptableBadVideoPixelBaseline = acceptableBadVideoPixelBaseline;
        this.acceptableBadVideoFpsBaseline = acceptableBadVideoFpsBaseline;
        this.acceptableMinVideoResolutionWidth = acceptableMinVideoResolutionWidth;
        this.acceptableMinVideoResolutionHeight = acceptableMinVideoResolutionHeight;
        this.streamPriority = streamPriority;
    }

    public int getAcceptableGoodVideoPixelBaseline() {
        return this.acceptableGoodVideoPixelBaseline;
    }

    public int getAcceptableGoodVideoFpsBaseline() {
        return this.acceptableGoodVideoFpsBaseline;
    }

    public int getAcceptableBadVideoPixelBaseline() {
        return this.acceptableBadVideoPixelBaseline;
    }

    public int getAcceptableBadVideoFpsBaseline() {
        return this.acceptableBadVideoFpsBaseline;
    }

    public int getAcceptableMinVideoResolutionWidth() {
        return this.acceptableMinVideoResolutionWidth;
    }

    public int getAcceptableMinVideoResolutionHeight() {
        return this.acceptableMinVideoResolutionHeight;
    }

    public int getStreamPriority() {
        return this.streamPriority;
    }
}
