package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalLocalVideoStats;

/* loaded from: classes7.dex */
public class LocalVideoStats {
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

    public LocalVideoStats() {
    }

    public LocalVideoStats(InternalLocalVideoStats internalStats) {
        this.sentKBitrate = internalStats.sentKBitrate;
        this.inputFrameRate = internalStats.inputFrameRate;
        this.sentFrameRate = internalStats.sentFrameRate;
        this.encoderOutputFrameRate = internalStats.encoderOutputFrameRate;
        this.rendererOutputFrameRate = internalStats.rendererOutputFrameRate;
        this.statsInterval = internalStats.statsInterval;
        this.videoLossRate = internalStats.videoLossRate;
        this.rtt = internalStats.rtt;
        this.encodedBitrate = internalStats.encodedBitrate;
        this.encodedFrameWidth = internalStats.encodedFrameWidth;
        this.encodedFrameHeight = internalStats.encodedFrameHeight;
        this.encodedFrameCount = internalStats.encodedFrameCount;
        this.codecType = internalStats.codecType;
        this.isScreen = internalStats.isScreen;
        this.jitter = internalStats.jitter;
        this.videoDenoiseMode = internalStats.videoDenoiseMode;
    }

    public String toString() {
        return "LocalVideoStats{sentKBitrate='" + this.sentKBitrate + "', inputFrameRate='" + this.inputFrameRate + "', sentFrameRate='" + this.sentFrameRate + "', encoderOutputFrameRate='" + this.encoderOutputFrameRate + "', rendererOutputFrameRate='" + this.rendererOutputFrameRate + "', videoLossRate='" + this.videoLossRate + "', rtt='" + this.rtt + "', statsInterval='" + this.statsInterval + "', encodedBitrate='" + this.encodedBitrate + "', encodedFrameWidth='" + this.encodedFrameWidth + "', encodedFrameHeight='" + this.encodedFrameHeight + "', encodedFrameCount='" + this.encodedFrameCount + "', codecType='" + this.codecType + "', isScreen='" + this.isScreen + "', jitter='" + this.jitter + "', videoDenoiseMode" + this.videoDenoiseMode + "'}";
    }
}
