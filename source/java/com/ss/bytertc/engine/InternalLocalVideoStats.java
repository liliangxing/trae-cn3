package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalLocalVideoStats {
    public int codecType;
    public int encodedBitrate;
    public int encodedFrameCount;
    public int encodedFrameHeight;
    public int encodedFrameWidth;
    public int encoderOutputFrameRate;
    public int inputFrameRate;
    public boolean isScreen;
    public int jitter;
    public int rendererOutputFrameRate;
    public int rtt;
    public int sentFrameRate;
    public float sentKBitrate;
    public int statsInterval;
    public int videoDenoiseMode;
    public float videoLossRate;

    public InternalLocalVideoStats() {
    }

    public InternalLocalVideoStats(float sentKBitrate, int inputFrameRate, int sentFrameRate, int encoderOutputFrameRate, int rendererOutputFrameRate, int statsInterval, float videoLossRate, int rtt, int encodedBitrate, int encodedFrameWidth, int encodedFrameHeight, int encodedFrameCount, int codecType, boolean isScreen, int jitter, int videoDenoiseMode) {
        this.sentKBitrate = sentKBitrate;
        this.inputFrameRate = inputFrameRate;
        this.sentFrameRate = sentFrameRate;
        this.encoderOutputFrameRate = encoderOutputFrameRate;
        this.rendererOutputFrameRate = rendererOutputFrameRate;
        this.statsInterval = statsInterval;
        this.videoLossRate = videoLossRate;
        this.rtt = rtt;
        this.encodedBitrate = encodedBitrate;
        this.encodedFrameWidth = encodedFrameWidth;
        this.encodedFrameHeight = encodedFrameHeight;
        this.encodedFrameCount = encodedFrameCount;
        this.codecType = codecType;
        this.isScreen = isScreen;
        this.jitter = jitter;
        this.videoDenoiseMode = videoDenoiseMode;
    }

    private static InternalLocalVideoStats create(float sentKBitrate, int inputFrameRate, int sentFrameRate, int encoderOutputFrameRate, int rendererOutputFrameRate, int statsInterval, float videoLossRate, int rtt, int encodedBitrate, int encodedFrameWidth, int encodedFrameHeight, int encodedFrameCount, int codecType, boolean isScreen, int jitter, int videoDenoiseMode) {
        return new InternalLocalVideoStats(sentKBitrate, inputFrameRate, sentFrameRate, encoderOutputFrameRate, rendererOutputFrameRate, statsInterval, videoLossRate, rtt, encodedBitrate, encodedFrameWidth, encodedFrameHeight, encodedFrameCount, codecType, isScreen, jitter, videoDenoiseMode);
    }
}
