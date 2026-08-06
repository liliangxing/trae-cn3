package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalRemoteVideoStats {
    public int codecType;
    public int decoderOutputFrameRate;
    public long e2eDelay;
    public int frozenRate;
    public int height;
    public boolean isScreen;
    public int jitter;
    public float receivedKBitrate;
    public int rendererOutputFrameRate;
    public int rtt;
    public int stallCount;
    public int stallDuration;
    public int statsInterval;
    public int superResolutionMode;
    public int videoIndex;
    public float videoLossRate;
    public int width;

    public InternalRemoteVideoStats() {
    }

    public InternalRemoteVideoStats(int width, int height, float videoLossRate, float receivedKBitrate, int decoderOutputFrameRate, int rendererOutputFrameRate, int stallCount, int stallDuration, long e2eDelay, boolean isScreen, int statsInterval, int rtt, int frozenRate, int codecType, int videoIndex, int jitter, int superResolutionMode) {
        this.width = width;
        this.height = height;
        this.videoLossRate = videoLossRate;
        this.receivedKBitrate = receivedKBitrate;
        this.decoderOutputFrameRate = decoderOutputFrameRate;
        this.rendererOutputFrameRate = rendererOutputFrameRate;
        this.stallCount = stallCount;
        this.stallDuration = stallDuration;
        this.e2eDelay = e2eDelay;
        this.isScreen = isScreen;
        this.statsInterval = statsInterval;
        this.rtt = rtt;
        this.frozenRate = frozenRate;
        this.codecType = codecType;
        this.videoIndex = videoIndex;
        this.jitter = jitter;
        this.superResolutionMode = superResolutionMode;
    }

    private static InternalRemoteVideoStats create(int width, int height, float videoLossRate, float receivedKBitrate, int decoderOutputFrameRate, int rendererOutputFrameRate, int stallCount, int stallDuration, long e2eDelay, boolean isScreen, int statsInterval, int rtt, int frozenRate, int codecType, int videoIndex, int jitter, int superResolutionMode) {
        return new InternalRemoteVideoStats(width, height, videoLossRate, receivedKBitrate, decoderOutputFrameRate, rendererOutputFrameRate, stallCount, stallDuration, e2eDelay, isScreen, statsInterval, rtt, frozenRate, codecType, videoIndex, jitter, superResolutionMode);
    }
}
